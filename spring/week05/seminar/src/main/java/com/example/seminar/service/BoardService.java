package com.example.seminar.service;

import com.example.seminar.dao.BoardDao;
import com.example.seminar.dao.PostDao;
import com.example.seminar.dto.BoardDetailDto;
import com.example.seminar.dto.BoardDto;
import com.example.seminar.dto.PostDto;
import com.example.seminar.entity.BoardEntity;
import com.example.seminar.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;
    private final PostDao postDao;

    public long createBoard(String name) {
        return boardDao.createBoard(name);
    }

    public List<BoardDto> getBoardList() {
        Iterator<BoardEntity> boardEntityIterator = boardDao.getBoardList();
        List<BoardDto> boardDtoList = new ArrayList<>();

        while (boardEntityIterator.hasNext()) {
            BoardEntity boardEntity = boardEntityIterator.next();
            boardDtoList.add(new BoardDto(boardEntity.getId(), boardEntity.getName(), postDao.getPostCountByBoardEntity(boardEntity)));
        }
        return boardDtoList;
    }

    public BoardDetailDto getBoardDetail(int id) {
        BoardEntity boardEntity = boardDao.getBoard(id);
        List<PostDto> postDtoList = new ArrayList<>();
        Iterator<PostEntity> postsByBoardEntity = postDao.getPostsByBoardEntity(boardEntity);

        while (postsByBoardEntity.hasNext()) {
            PostEntity postEntity = postsByBoardEntity.next();
            postDtoList.add(new PostDto((int) postEntity.getId(), postEntity.getTitle(), postEntity.getContent(), postEntity.getWriter(), id));
        }
        return new BoardDetailDto(id, boardEntity.getName(), postDtoList);
    }

    public void updateBoardTitle(int id, String title) {
        boardDao.updateBoardTitle(id, title);
    }

    public void deleteBoard(int id) {
        boardDao.deleteBoard(id);
    }
}
