package com.bookstore;

import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LeftJoinFetchApplication {

    private final BookstoreService bookstoreService;

    public LeftJoinFetchApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LeftJoinFetchApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            List<Author> authors = bookstoreService.fetchAuthorWithBooks();
            authors.forEach(a -> System.out.println("Author name: " + a.getName() + " Books: " + a.getBooks()));

            List<Book> books = bookstoreService.fetchBookWithAuthor();
            books.forEach(b -> System.out.println("Book title: " + b.getTitle() + " Author: " + b.getAuthor()));
        };
    }
}
