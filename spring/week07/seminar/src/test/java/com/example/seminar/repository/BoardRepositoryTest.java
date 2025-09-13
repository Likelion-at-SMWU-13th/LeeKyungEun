package com.example.seminar.repository;

import com.example.seminar.entity.Board;
import com.example.seminar.entity.Post;
import com.example.seminar.entity.Writer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    WriterRepository writerRepository;

    @Test
    void saveAndReadTest() {

        Board board = new Board();
        board.setBoardName("Board 1");
        boardRepository.save(board);

        Writer writer = new Writer();
        writer.setName("Writer 1");
        writerRepository.save(writer);

        Post post = new Post();
        post.setContent("This is a post");
        post.setBoard(board);
        postRepository.save(post);
        board.addPost(post);

        Post post2 = new Post();
        post2.setContent("This is a post2");
        post2.setBoard(board);
        postRepository.save(post2);
        board.addPost(post2);

        System.out.println("---- 게시판 조회 ----");
        System.out.println("Board = " + boardRepository.findAll());

        System.out.println("---- 게시판 -> 게시글 조회 ----");
        int i = 1;
        for (Post p : boardRepository.findById(board.getId()).get().getPosts()) {
            System.out.println("BoardPosts " + i++ + "= " + p);
        }
    }

}