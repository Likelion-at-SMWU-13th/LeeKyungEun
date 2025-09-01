package com.example.seminar.dao;

import com.example.seminar.dto.PostDto;
import com.example.seminar.entity.BoardEntity;
import com.example.seminar.entity.PostEntity;
import com.example.seminar.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;
    private final BoardDao boardDao;

    public PostDao(@Autowired PostRepository postRepository, BoardDao boardDao) {
        this.postRepository = postRepository;
        this.boardDao = boardDao;
    }

    public void createPost(PostDto dto){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setWriter(dto.getWriter());
        postEntity.setBoardEntity(boardDao.getBoard(dto.getBoardId()));

        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int id){
        Optional<PostEntity> postEntity = this.postRepository.findById((long)id);
        if (postEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();
    }

    public Iterator<PostEntity> readPostAll(){
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int id, PostDto dto){
        Optional<PostEntity> targetEntity = this.postRepository.findById((long)id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(
                dto.getTitle() == null ? postEntity.getTitle(): dto.getTitle()
        );
        postEntity.setContent(
                dto.getContent() == null ? postEntity.getContent(): dto.getContent()
        );
        postEntity.setWriter(
                dto.getWriter() == null ? postEntity.getWriter(): dto.getWriter()
        );
        this.postRepository.save(postEntity);
    }

    public void deletePost(int id){
        Optional<PostEntity> targetEntity = this.postRepository.findById((long)id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }

    public int getPostCountByBoardEntity(BoardEntity boardEntity){
        return postRepository.countByBoardEntity(boardEntity);
    }

    public Iterator<PostEntity> getPostsByBoardEntity(BoardEntity boardEntity){
        Optional<List<PostEntity>> targetList = postRepository.findByBoardEntity(boardEntity);
        if(targetList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return targetList.get().iterator();
    }

}