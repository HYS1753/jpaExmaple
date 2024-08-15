package com.example.jpaExample.data.repository.h2;

import com.example.jpaExample.data.entity.h2.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<BookEntity, String> {

}
