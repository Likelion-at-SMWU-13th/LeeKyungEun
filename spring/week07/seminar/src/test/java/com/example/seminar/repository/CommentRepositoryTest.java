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
class CommentRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    WriterRepository writerRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    Long commentId;

    @BeforeEach
    void setUp() {
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

        Comment comment = new Comment();
        comment.setContent("This is a comment");
        comment.setPost(post);
        comment.setWriter(writer);
        Comment savedComment = commentRepository.save(comment);
        commentId = savedComment.getId();

        post.addComment(comment);

        writer.addComment(comment);
        writer.addPost(post);
    }

    @Test
    void saveAndReadTest() {

        System.out.println("---- 댓글 조회 ----");
        System.out.println("Comment = " + commentRepository.findAll());

        System.out.println("---- 댓글 -> 게시글 조회 ----");
        System.out.println("CommentPost = " + commentRepository.findById(commentId).get().getPost());

        System.out.println("---- 댓글 -> 작성자 조회 ----");
        System.out.println("CommentWriter = " + commentRepository.findById(commentId).get().getWriter());

    }
}