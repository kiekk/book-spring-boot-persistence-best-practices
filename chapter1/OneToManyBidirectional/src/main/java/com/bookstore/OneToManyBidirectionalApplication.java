package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToManyBidirectionalApplication {

    private final BookstoreService bookstoreService;

    public OneToManyBidirectionalApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OneToManyBidirectionalApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert author with books  ...");
            bookstoreService.insertAuthorWithBooks();

            System.out.println("\nDelete a book of an author...");
            bookstoreService.deleteBookOfAuthor();

            System.out.println("\nInsert other author with books  ...");
            bookstoreService.insertOtherAuthorWithBooks();

            System.out.println("\nDelete all book of an author...");
            bookstoreService.deleteAllBooksOfAuthor();
        };
    }
}
