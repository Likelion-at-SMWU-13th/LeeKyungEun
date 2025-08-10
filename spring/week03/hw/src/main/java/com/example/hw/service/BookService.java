package com.example.hw.service;

import com.example.hw.exception.BookNotFoundException;
import com.example.hw.exception.DuplicateBookException;
import com.example.hw.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle())) {
                throw new DuplicateBookException("해당 제목의 책이 이미 존재합니다.");
            }
        }
        books.add(book);
    }

    public List<Book> getBooks() {
        if (books.isEmpty()) {
            throw new BookNotFoundException("책 목록을 찾지 못했습니다.");
        }
        return books;
    }

}
