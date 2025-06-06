package com.bookstore.repository;

import com.bookstore.dto.AuthorNameBookTitle;
import com.bookstore.dto.BookTitleAndFormatType;
import com.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepositoryCrossJoin extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b.title AS title, f.formatType AS formatType "
            + "FROM Book b, Format f")
    List<BookTitleAndFormatType> findBooksAndFormatsJpql();

    @Query(value = "SELECT b.title AS title, f.format_type AS formatType "
            + "FROM book b CROSS JOIN format f",
            nativeQuery = true)
    List<BookTitleAndFormatType> findBooksAndFormatsSql();

    @Query(value = "SELECT b.title AS title, b.author.name AS name FROM Book b")
    List<AuthorNameBookTitle> findBooksAndAuthorsJpql();
}
