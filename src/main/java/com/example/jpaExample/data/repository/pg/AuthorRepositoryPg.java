package com.example.jpaExample.data.repository.pg;

import com.example.jpaExample.data.entity.pg.AuthorPgEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepositoryPg extends JpaRepository<AuthorPgEntity, String> {
}
