package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectionApplication {

    private final BookstoreService bookstoreService;

    public ProjectionApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectionApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\n Calling fetchAuthorByNameAsEntityJpql():");
            bookstoreService.fetchAuthorByNameAsEntityJpql();

            System.out.println("\n\n Calling fetchAuthorByNameAsDtoNameEmailJpql():");
            bookstoreService.fetchAuthorByNameAsDtoNameEmailJpql();

            System.out.println("\n\n Calling fetchAuthorByNameAsDtoGenreJpql():");
            bookstoreService.fetchAuthorByNameAsDtoGenreJpql();

            System.out.println("\n\n Calling fetchAuthorByNameAndAgeAsEntityJpql():");
            bookstoreService.fetchAuthorByNameAndAgeAsEntityJpql();

            System.out.println("\n\n Calling fetchAuthorByNameAndAgeAsDtoNameEmailJpql():");
            bookstoreService.fetchAuthorByNameAndAgeAsDtoNameEmailJpql();

            System.out.println("\n\n Calling fetchAuthorByNameAndAgeAsDtoGenreJpql():");
            bookstoreService.fetchAuthorByNameAndAgeAsDtoGenreJpql();

            System.out.println("\n\n Calling fetchAuthorsAsEntitiesJpql():");
            bookstoreService.fetchAuthorsAsEntitiesJpql();

            System.out.println("\n\n Calling fetchAuthorsAsDtoJpql():");
            bookstoreService.fetchAuthorsAsDtoJpql();
        };
    }
}
