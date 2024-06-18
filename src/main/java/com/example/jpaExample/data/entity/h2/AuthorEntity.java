package com.example.jpaExample.data.entity.h2;
/****************************************************************************************
 * Copyright(c) 2021-2023 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * hys1753@kyobobook.co.kr        2024-03-05
 *
 ****************************************************************************************/

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Persistable;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : AuthorPgEntity
 * @Date : 2024-03-05
 * @description :
 */
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
