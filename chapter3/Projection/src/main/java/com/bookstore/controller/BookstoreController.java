package com.bookstore.controller;

import com.bookstore.dto.AuthorDto;
import com.bookstore.service.BookstoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookstoreController {
    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/1")
    public List<AuthorDto> fetchAll() {
        return bookstoreService.fetchAll();
    }

    @GetMapping("/2")
    public List<AuthorDto> fetchAgeNameGenre() {
        return bookstoreService.fetchAgeNameGenre();
    }

    @GetMapping("/3")
    public List<AuthorDto> fetchNameEmail() {
        return bookstoreService.fetchNameEmail();
    }
}
