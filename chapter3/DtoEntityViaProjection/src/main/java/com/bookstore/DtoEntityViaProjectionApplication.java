package com.bookstore;

import com.bookstore.dto.BookstoreDto;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DtoEntityViaProjectionApplication {

    private final BookstoreService bookstoreService;

    public DtoEntityViaProjectionApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DtoEntityViaProjectionApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            List<BookstoreDto> authors = bookstoreService.fetchAuthors();
            authors.forEach(a -> System.out.println(a.getAuthor() + ", Title: " + a.getTitle()));
        };
    }
}
