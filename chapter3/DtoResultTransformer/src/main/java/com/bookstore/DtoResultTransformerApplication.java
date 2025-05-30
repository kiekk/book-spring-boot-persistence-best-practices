package com.bookstore;

import com.bookstore.dto.AuthorDtoNoSetters;
import com.bookstore.dto.AuthorDtoWithSetters;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DtoResultTransformerApplication {

    private final BookstoreService bookstoreService;

    public DtoResultTransformerApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DtoResultTransformerApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("Fetch authors via a DTO with setters:");

            List<AuthorDtoWithSetters> authors1 = bookstoreService.fetchAuthorsWithSetters();
            for (AuthorDtoWithSetters author : authors1) {
                System.out.println("Author name: " + author.getName()
                        + " | Age: " + author.getAge());
            }

            System.out.println("\nFetch authors via a DTO without setters:");

            List<AuthorDtoNoSetters> authors2 = bookstoreService.fetchAuthorsNoSetters();
            for (AuthorDtoNoSetters author : authors2) {
                System.out.println("Author name: " + author.getName()
                        + " | Age: " + author.getAge());
            }
        };
    }
}
