package com.example.jpaExample.data.entity.pg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Persistable;

@Entity
@Data
@Table(name = "AUTHOR")
public class AuthorPgEntity extends AuditingPgEntity implements Persistable<String> {
    @Id
    @Column(name = "AUTHOR_ID")
    private String id;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Override
    public boolean isNew() {
        return super.getCreatedTime() == null;
    }
}
