package com.example.jpaExample.data.entity.h2;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Persistable;

import java.util.List;


@Entity
@Data
@Table(name = "AUTHOR")
public class AuthorEntity extends AuditingEntity implements Persistable<String> {
    @Id
    @Column(name = "AUTHOR_ID")
    private String id;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Override
    public boolean isNew() {
        return super.getCreatedTime() == null; // (5)
    }
}
