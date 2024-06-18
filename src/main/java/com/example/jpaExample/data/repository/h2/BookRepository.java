package com.example.jpaExample.data.repository.h2;
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

import com.example.jpaExample.data.entity.h2.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : BookRepository
 * @Date : 2024-03-05
 * @description :
 */
public interface BookRepository extends JpaRepository<BookEntity, String> {

}
