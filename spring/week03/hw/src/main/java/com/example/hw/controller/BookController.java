package com.example.hw.controller;

import com.example.hw.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hw.model.Book;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;  // 생성자 1개라 @Autowired 생략
    }

    @GetMapping
    public String getBookList(Model model) {
        var books = bookService.getBooks();
        model.addAttribute("books", books);

        return "books.html";
    }

    @PostMapping
    public String addBook(Book book, Model model) {

        bookService.addBook(book);

        var books = bookService.getBooks();
        model.addAttribute("books", books);

        return "books.html";
    }
}
