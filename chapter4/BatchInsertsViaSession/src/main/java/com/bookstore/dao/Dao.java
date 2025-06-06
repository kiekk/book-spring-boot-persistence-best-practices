package com.bookstore.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

@Repository
@Transactional
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID> {
    private static final Logger logger = Logger.getLogger(Dao.class.getName());

    private static final int BATCH_SIZE = 30;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends T> void saveInBatch(Iterable<S> entities) {
        if (entities == null) {
            throw new IllegalArgumentException("The given Iterable of entities cannot be null!");
        }

        int i = 0;

        Session session = entityManager.unwrap(Session.class);
        session.setJdbcBatchSize(BATCH_SIZE);

        for (S entity : entities) {
            entityManager.persist(entity);

            i++;

            // Flush a batch of inserts and release memory
            if (i % session.getJdbcBatchSize() == 0 && i > 0) {
                logger.log(INFO, "Flushing the EntityManager containing {0} entities ...", i);

                entityManager.flush();
                entityManager.clear();
                i = 0;
            }
        }

        if (i > 0) {
            logger.log(INFO, "Flushing the remaining {0} entities ...", i);

            entityManager.flush();
            entityManager.clear();
        }
    }
}
