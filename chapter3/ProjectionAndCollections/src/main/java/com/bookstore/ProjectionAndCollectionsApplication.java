package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectionAndCollectionsApplication {

    private final BookstoreService bookstoreService;

    public ProjectionAndCollectionsApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectionAndCollectionsApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\nFetch authors with books via query builder mechanism");
            System.out.println("-----------------------------------------------------------------");
            bookstoreService.fetchAuthorsWithBooksQueryBuilderMechanism();

            System.out.println("\n\nFetch authors with books via JPQL query");
            System.out.println("-----------------------------------------------------------------");
            bookstoreService.fetchAuthorsWithBooksViaQuery();

            System.out.println("\n\nFetch authors with books via JOIN FETCH");
            System.out.println("-----------------------------------------------------------------");
            bookstoreService.fetchAuthorsWithBooksViaJoinFetch();

            System.out.println("\n\nFetch authors with books via query and simple DTO");
            System.out.println("-----------------------------------------------------------------");
            bookstoreService.fetchAuthorsWithBooksViaQuerySimpleDto();

            System.out.println("\n\nFetch authors with books via array of objects:");
            System.out.println("-----------------------------------------------------------------");
            bookstoreService.fetchAuthorsWithBooksViaArrayOfObjects();

            System.out.println("\n\nFetch authors with books via array of objects and transform to DTO:");
            System.out.println("-----------------------------------------------------------------");
            bookstoreService.fetchAuthorsWithBooksViaArrayOfObjectsAndTransformToDto();

            System.out.println("\n\nFetch authors with books via JdbcTemplate as DTO:");
            System.out.println("-----------------------------------------------------------------");
            bookstoreService.fetchAuthorsWithBooksViaJdbcTemplateToDto();
        };
    }
}
