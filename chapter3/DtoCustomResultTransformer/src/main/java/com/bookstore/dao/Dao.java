package com.bookstore.dao;

import com.bookstore.dto.AuthorDto;
import com.bookstore.transformer.AuthorBookTransformer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Dao implements AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDto> fetchAuthorWithBook() {
        Query query = entityManager
                .createNativeQuery(
                        "SELECT a.id AS author_id, a.name AS name, a.age AS age, "
                                + "b.id AS book_id, b.title AS title "
                                + "FROM author a JOIN book b ON a.id=b.author_id")
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(new AuthorBookTransformer());

        List<AuthorDto> authors = query.getResultList();

        return authors;
    }
}
