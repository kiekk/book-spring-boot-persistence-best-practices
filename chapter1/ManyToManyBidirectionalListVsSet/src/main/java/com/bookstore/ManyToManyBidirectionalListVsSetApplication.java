package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToManyBidirectionalListVsSetApplication {

    private final BookstoreService bookstoreService;

    public ManyToManyBidirectionalListVsSetApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyBidirectionalListVsSetApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("===================================================");
            System.out.println("Populate database and remove a book (List case) ...");
            System.out.println("===================================================");
            bookstoreService.persistAuthorWithBooksAndRemoveOneBookList();

            System.out.println("\n");
            System.out.println("==================================================");
            System.out.println("Populate database and remove a book (Set case) ...");
            System.out.println("==================================================");
            bookstoreService.persistAuthorWithBooksAndRemoveOneBookSet();

            System.out.println("\n");
            System.out.println("==================================================");
            System.out.println("get AuthorSet ...");
            System.out.println("==================================================");
            bookstoreService.getAuthorSetByBookId();
        };
    }

}
