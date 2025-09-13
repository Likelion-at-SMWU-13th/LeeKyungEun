package com.example.seminar.repository;

import com.example.seminar.entity.Board;
import com.example.seminar.entity.Comment;
import com.example.seminar.entity.Post;
import com.example.seminar.entity.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class WriterRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    WriterRepository writerRepository;

    @Autowired
    CommentRepository commentRepository;

    Long writerId;

    @BeforeEach
    void setUp() {
        Board board = new Board();
        board.setBoardName("Board 1");
        boardRepository.save(board);

        Writer writer = new Writer();
        writer.setName("Writer 1");
        Writer savedWriter = writerRepository.save(writer);
        writerId = savedWriter.getId();

        Post post = new Post();
        post.setContent("This is a post");
        post.setBoard(board);
        postRepository.save(post);
        board.addPost(post);

        Comment comment = new Comment();
        comment.setContent("This is a comment");
        comment.setPost(post);
        comment.setWriter(writer);
        commentRepository.save(comment);

        Comment comment2 = new Comment();
        comment2.setContent("This is a comment2");
        comment2.setPost(post);
        comment2.setWriter(writer);
        commentRepository.save(comment2);

        post.addComment(comment);
        post.addComment(comment2);

        writer.addComment(comment);
        writer.addComment(comment2);
        writer.addPost(post);
    }

    @Test
    void saveAndReadTest() {

        System.out.println("---- 작성자 조회 ----");
        System.out.println("Writer = " + writerRepository.findAll());

        System.out.println("---- 작성자 -> 게시글 조회 ----");
        int i = 1;
        for (Post p : writerRepository.findById(writerId).get().getPosts()) {
            System.out.println("WriterPost " + i++ + "= " + p);
        }

        System.out.println("---- 작성자 -> 댓글 조회 ----");
        int j = 1;
        for (Comment c : writerRepository.findById(writerId).get().getComments()) {
            System.out.println("WriterComment " + j++ + "= " + c);
        }

    }

}