package com.bookstore;

import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JoinFetchApplication {

    private final BookstoreService bookstoreService;

    public JoinFetchApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JoinFetchApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            Author author = bookstoreService.fetchAuthorWithBooksByName();
            System.out.println("\nAuthor name: " + author.getName() + " Books: " + author.getBooks() + "\n");

            Book book = bookstoreService.fetchBookWithAuthorByIsbn();
            System.out.println("\nTitle: " + book.getTitle() + " author: " + book.getAuthor() + "\n");
        };
    }
}
