package com.bookstore.controller;

import com.bookstore.entity.Author;
import com.bookstore.service.BookstoreService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

@RestController
public class BookstoreController {
    private final BookstoreService bookstoreService;
    private final SimpleFilterProvider filterProvider;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
        filterProvider = new SimpleFilterProvider().addFilter("AuthorId",
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "age", "genre"));
        filterProvider.setFailOnUnknownId(false);
    }

    @GetMapping("/author/avatar/{id}")
    public String fetchAuthorAvatarViaId(@PathVariable long id) {
        return Base64.getEncoder().encodeToString(bookstoreService.fetchAuthorAvatarViaId(id));
    }

    @GetMapping("/authors/{age}")
    public MappingJacksonValue fetchAuthorsByAgeGreaterThanEqual(@PathVariable int age) {
        List<Author> authors = bookstoreService.fetchAuthorsByAgeGreaterThanEqual(age);

        MappingJacksonValue wrapper = new MappingJacksonValue(authors);
        wrapper.setFilters(filterProvider);
        return wrapper;
    }

    @GetMapping("/authors/details/{age}")
    public List<Author> fetchAuthorsDetailsByAgeGreaterThanEqual(@PathVariable int age) {
        return bookstoreService.fetchAuthorsDetailsByAgeGreaterThanEqual(age);
    }
}
