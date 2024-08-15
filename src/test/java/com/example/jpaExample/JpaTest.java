package com.example.jpaExample;

import com.example.jpaExample.config.H2DbConfig;
import com.example.jpaExample.data.entity.h2.AuthorEntity;
import com.example.jpaExample.data.entity.h2.BookEntity;
import com.example.jpaExample.data.repository.h2.BookRepository;
import com.example.jpaExample.service.impl.H2ServiceImpl;
import jakarta.persistence.*;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.TransactionalException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class JpaTest {

    @Autowired
    H2DbConfig config;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    H2ServiceImpl h2Service;

    /*
    1. JPA 에서 가장 중요한 2가지
       - 객체와 관계형 데이터베이스 매핑하기(Object Relational Mapping)
       - 영속성 컨텍스트(엔티티를 영구 저장하는 환경)
          - 영속성 컨텍스트는 논리적인 개념, 눈이 보이지 않음
          - 엔티티 매니저를 통해서 영속성 컨텍스트에 접근
          - 이점 : 1차 캐시, 동일성 보장, 트랜잭션을 지원하는 쓰기 지연, 변경감지, 지연로딩
       - 엔티티의 생명주기
          - 비영속(new/transient) : 영속성 컨텐스트와 전혀 관계가 없는 새로운 상태
          - 영속(managed) : 영속성 컨텐스트에 관리되는 상태
          - 준영속(detached) : 영속성 컨텐스트에 저장되었다가 분리된 상태
          - 삭제(removed) : 삭제된 상태
       - 플러시 : 영속성 컨텍스트의 변경사항을 데이터베이스에 적용
          - 변경감지(dirty check)
          - 수정된 엔티티 쓰기 지연 SQL 저장소에 등록
          - 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송(등록, 수정, 삭제 쿼리)
          - 플러쉬 하더라고 1차 캐시는 삭제 안됨.
          - 플러시 하는 방법 : 직접 호출(em.flush()), 트랜잭션 커밋, JPQL 쿼리 실행
     2. 엔티티 매핑
        - 객체와 테이블 매핑 : @Entity, @Table
        - 필드와 컬럼 매핑 : @Column
        - 기본키 매핑 : @Id
        - 연관관계 매핑 : @ManyToOne, @OneToMany, @ManyToMany, @OneToOne
        - Entity
           - 기본 생성자 필수(파라미터 없는 public 또는 protected 생성자
           - final 클래스, enum, interface, inner 클래스 사용 불가
           - 저장할 필드에 final 사용 안됨.
     3. 연관관계
        - 객체의 양방향 관계는 사실 양방향 관계가 아니라 서로 다른 단방향 관계 2개이다.
        - 연관관계의 주인
           - 객체의 두 관계중 하나를 연관관계의 주인으로 지정
           - 연관관계의 주인만이 외래키를 관리(등록, 수정)
           - 주인이 아닌 쪽은 읽기만 가능(중요!)
           - 주인은 mappedBy 속성을 사용하지 않는다.
           - 주인이 아니면 mappedBy 속성으로 주인을 지정한다.
     */

    /*
    EntityManagerFactory 는 하나만 생성해서 어플리케이션 전체 공유
    EntityManager 는 요청이 올 때 마다 생성후 처리 완료 되면 폐기(쓰레드간 공유가 안됨.)
    JPA 의 모등 데이터 변경은 트랜젝션 안에서 실행
     */
    @Test
    void insertTest() {
        EntityManagerFactory emf = config.h2EntityManager().getNativeEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            BookEntity bookEntity = new BookEntity();
            bookEntity.setId("1");
            bookEntity.setBookName("first book");
            bookEntity.setBookPrice(10000);
            AuthorEntity author = new AuthorEntity();
            author.setAuthorName("firstAuthor");
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

    @Test
    void selectTest() {
        EntityManagerFactory emf = config.h2EntityManager().getNativeEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            BookEntity book = em.find(BookEntity.class, 1);
            log.info("book.id: " + book.getId());
            log.info("book.bookName: " + book.getBookName());
            log.info("book.bookPrice: " + book.getBookPrice());
            log.info("book.author: " + book.getAuthor());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    /*
    JPQL : 엔티티 객체를 대상으로 쿼리
    SQL  : 데이터베이스 테이블을 대상으로 쿼리
     */
    @Test
    void selectJpqlTest() {
        EntityManagerFactory emf = config.h2EntityManager().getNativeEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            List<BookEntity> result = em.createQuery("select m from BookEntity m", BookEntity.class).getResultList();

            for (BookEntity book : result) {
                log.info("book.name: " + book.getBookName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    void updateTest() {
        EntityManagerFactory emf = config.h2EntityManager().getNativeEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            BookEntity book = em.find(BookEntity.class, 1);
            book.setBookName("changed book");

            // persist(book) -> 할 필요 없음 JPA 가 commit 하기 전에 변경 사항 감지하여 자동으로 업데이트 진행
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    void deleteTest() {
        EntityManagerFactory emf = config.h2EntityManager().getNativeEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
//            BookEntity book = em.find(BookEntity.class, 1);
//            em.remove(book);

            // Author Entity에 cascade 처리 되어 연관된 Book 같이 삭제
            AuthorEntity author = em.find(AuthorEntity.class, 1);
            em.remove(author);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
//    @Transactional (EntityManager 와 같이 사용 안됨)
    void upsertTest() {
        EntityManagerFactory emf = config.h2EntityManager().getNativeEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            BookEntity book = em.find(BookEntity.class, 1);
            book.setBookPrice(39800);

            tx.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    @Test
    void springDataJpaUpsertTest() {
        BookEntity book = bookRepository.findById("1").get();
        book.setBookPrice(12345);
    }
}
