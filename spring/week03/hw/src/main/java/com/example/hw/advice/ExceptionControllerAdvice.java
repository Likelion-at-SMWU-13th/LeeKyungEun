package com.example.hw.advice;

import com.example.hw.dto.ErrorDetails;
import com.example.hw.exception.BookNotFoundException;
import com.example.hw.exception.DuplicateBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> bookNotFoundExceptionHandler(BookNotFoundException e) {
        ErrorDetails bookNotFound = ErrorDetails.builder().message(e.getMessage()).build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(bookNotFound);
    }

    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity<ErrorDetails> duplicateBookExceptionHandler(DuplicateBookException e) {
        ErrorDetails duplicateBook = ErrorDetails.builder().message(e.getMessage()).build();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(duplicateBook);
    }
}
