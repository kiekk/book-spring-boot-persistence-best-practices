package com.bookstore.repository;

import com.bookstore.dto.BookstoreDto;
import com.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a AS author, b.title AS title " +
            "FROM Author a JOIN Book b ON a.genre=b.genre ORDER BY a.id")
    List<BookstoreDto> fetchAll();
}
