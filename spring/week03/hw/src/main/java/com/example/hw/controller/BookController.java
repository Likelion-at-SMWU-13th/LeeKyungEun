package com.example.hw.controller;

import com.example.hw.exception.BookNotFoundException;
import com.example.hw.exception.DuplicateBookException;
import com.example.hw.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hw.model.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;  // 생성자 1개라 @Autowired 생략
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBookList() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity
                .status(200)
                .body(books);
    }

    @PostMapping
    public ResponseEntity<List<Book>> addBook(Book book, Model model) {

        bookService.addBook(book);
        List<Book> books = bookService.getBooks();
        return ResponseEntity
                .status(201)
                .body(books);
    }
}
