package com.bookstore.service;

import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import com.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // 기본 setter 메서드를 사용한 방식
    public void persistAuthorWithBooksWithoutFluentApi() {
        Author author = new Author();
        author.setName("Joana Nimar");
        author.setAge(34);
        author.setGenre("History");

        Book book1 = new Book();
        book1.setTitle("A History of Ancient Prague");
        book1.setIsbn("001-JN");

        Book book2 = new Book();
        book2.setTitle("A People's History");
        book2.setIsbn("002-JN");

        // addBook() is a helper method defined in Author class
        author.addBook(book1);
        author.addBook(book2);

        authorRepository.save(author);
    }

    // fluent + setter 메서드를 사용한 방식
    public void persistAuthorWithBooks() {
        Author author = new Author()
                .setName("Joana Nimar")
                .setAge(34)
                .setGenre("History")
                .addBook(new Book()
                        .setTitle("A History of Ancient Prague")
                        .setIsbn("001-JN"))
                .addBook(new Book()
                        .setTitle("A People's History")
                        .setIsbn("002-JN"));

        authorRepository.save(author);
    }

    // fluent 메서드 체이닝을 사용한 방식
    public void persistAuthorWithBooks2() {
        Author author = new Author()
                .name("Joana Nimar")
                .age(34)
                .genre("History")
                .addBook(new Book()
                        .title("A History of Ancient Prague")
                        .isbn("001-JN"))
                .addBook(new Book()
                        .title("A People's History")
                        .isbn("002-JN"));

        authorRepository.save(author);
    }

    // 빌더 패턴을 사용한 방식
    public void persistAuthorWithBooks3() {
        Author author = new Author.Builder()
                .name("Joana Nimar")
                .age(34)
                .genre("History")
                .books(List.of(
                        new Book.Builder()
                                .title("A History of Ancient Prague")
                                .isbn("001-JN")
                                .build(),
                        new Book.Builder()
                                .title("A People's History")
                                .isbn("002-JN").build())
                )
                .build();

        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public void displayAuthorWithBooks() {
        Author author = authorRepository.findByName("Joana Nimar");

        System.out.println(author + "  Books: " + author.getBooks());
    }
}
