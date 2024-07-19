package com.example.jpaExample;

import com.example.jpaExample.config.H2DbConfig;
import com.example.jpaExample.data.entity.h2.AuthorEntity;
import com.example.jpaExample.data.entity.h2.BookEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@SpringBootTest
public class JpaTest {

    @Autowired
    H2DbConfig config;

    @Test
    void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SystemException, NotSupportedException {
        EntityManagerFactory emf = config.h2EntityManager().getNativeEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            BookEntity bookEntity = new BookEntity();
            bookEntity.setId("2");
            bookEntity.setBookName("hello");
            bookEntity.setBookPrice(1234);
            AuthorEntity author = new AuthorEntity();
            author.setAuthorName("helloAuthor");
            author.setId("1");
            bookEntity.setAuthor(author);
            em.persist(author);
            em.persist(bookEntity);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
