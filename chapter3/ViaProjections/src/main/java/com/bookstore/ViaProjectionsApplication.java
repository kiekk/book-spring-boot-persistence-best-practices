package com.bookstore;

import com.bookstore.projection.AuthorNameAge;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ViaProjectionsApplication {

    private final BookstoreService bookstoreService;

    public ViaProjectionsApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ViaProjectionsApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            List<AuthorNameAge> authors = bookstoreService.fetchFirst2ByBirthplace();
            System.out.println("Number of authors:" + authors.size());

            for (AuthorNameAge author : authors) {
                System.out.println("Author name: " + author.getName() + " | Age: " + author.getAge());
            }
        };
    }
}
