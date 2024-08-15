package com.example.jpaExample.data.repository.h2;

import com.example.jpaExample.data.entity.h2.AuthorEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, String> {

}
