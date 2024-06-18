package com.example.jpaExample.data.repository.pg;
/****************************************************************************************
 * Copyright(c) 2021-2023 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * hys1753@kyobobook.co.kr        2024-03-07
 *
 ****************************************************************************************/

import com.example.jpaExample.data.entity.pg.AuthorPgEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : AuthorRepository
 * @Date : 2024-03-07
 * @description :
 */
public interface AuthorRepositoryPg extends JpaRepository<AuthorPgEntity, String> {
}
