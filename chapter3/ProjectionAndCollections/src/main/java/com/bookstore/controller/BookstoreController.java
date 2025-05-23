package com.bookstore.controller;

import com.bookstore.dto.AuthorDto;
import com.bookstore.dto.SimpleAuthorDto;
import com.bookstore.service.BookstoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authorsAndbooks/1")
    public List<AuthorDto> fetchAuthorsWithBooksQueryBuilderMechanism() {
        return bookstoreService.fetchAuthorsWithBooksQueryBuilderMechanism();
    }

    @GetMapping("/authorsAndbooks/2")
    public List<AuthorDto> fetchAuthorsWithBooksViaQuery() {
        return bookstoreService.fetchAuthorsWithBooksViaQuery();
    }

    @GetMapping("/authorsAndbooks/3")
    public Set<AuthorDto> fetchAuthorsWithBooksViaJoinFetch() {
        return bookstoreService.fetchAuthorsWithBooksViaJoinFetch();
    }

    @GetMapping("/authorsAndbooks/4")
    public List<SimpleAuthorDto> fetchAuthorsWithBooksViaQuerySimpleDto() {
        return bookstoreService.fetchAuthorsWithBooksViaQuerySimpleDto();
    }

    @GetMapping("/authorsAndbooks/5")
    public List<Object[]> fetchAuthorsWithBooksViaArrayOfObjects() {
        return bookstoreService.fetchAuthorsWithBooksViaArrayOfObjects();
    }

    @GetMapping("/authorsAndbooks/6")
    public List<com.bookstore.transform.dto.AuthorDto> fetchAuthorsWithBooksViaArrayOfObjectsAndTransformToDto() {
        return bookstoreService.fetchAuthorsWithBooksViaArrayOfObjectsAndTransformToDto();
    }

    @GetMapping("/authorsAndbooks/7")
    public List<com.bookstore.jdbcTemplate.dto.AuthorDto> fetchAuthorsWithBooksViaJdbcTemplateToDto() {
        return bookstoreService.fetchAuthorsWithBooksViaJdbcTemplateToDto();
    }

}
