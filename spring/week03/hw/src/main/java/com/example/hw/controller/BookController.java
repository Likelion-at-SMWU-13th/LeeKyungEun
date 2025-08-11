package com.example.hw.controller;

import com.example.hw.exception.BookNotFoundException;
import com.example.hw.exception.DuplicateBookException;
import com.example.hw.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hw.model.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Book 컨트롤러", description = "책 목록 조회 및 책 추가")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;  // 생성자 1개라 @Autowired 생략
    }

    @GetMapping
    @Operation(summary = "get book list api", description = "책 목록 조회하기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공했습니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "책 목록을 조회하지 못했습니다.", content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<List<Book>> getBookList() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity
                .status(200)
                .body(books);
    }

    @PostMapping
    @Parameters({
            @Parameter(name = "title", description = "책이름", example = "멋쟁이사자처럼"),
            @Parameter(name = "author", description = "작가", example = "김멋사"),
            @Parameter(name = "price", description = "가격", example = "50000")
    })
    public ResponseEntity<List<Book>> addBook(Book book) {

        bookService.addBook(book);
        List<Book> books = bookService.getBooks();
        return ResponseEntity
                .status(201)
                .body(books);
    }
}
