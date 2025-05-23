package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityGraphAttributePathsApplication {

    private final BookstoreService bookstoreService;

    public EntityGraphAttributePathsApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EntityGraphAttributePathsApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nCall AuthorRepository#findAll():");
            bookstoreService.displayAuthorsAndBooks();

            System.out.println("\nCall AuthorRepository#findByAgeLessThanOrderByNameDesc(int age):");
            bookstoreService.displayAuthorsAndBooksByAge(40);

            System.out.println("\nCall AuthorRepository#findAll(Specification spec):");
            bookstoreService.displayAuthorsAndBooksByAgeWithSpec();

            System.out.println("\nCall AuthorRepository#fetchAllAgeBetween20And40():");
            bookstoreService.displayAuthorsAndBooksFetchAllAgeBetween20And40();

            System.out.println("\nCall BookRepository#findAll():");
            bookstoreService.displayBooksAndAuthors();
        };
    }

}
