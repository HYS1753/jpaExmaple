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

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : BookEntity
 * @Date : 2024-03-05
 * @description :
 */
@Entity
@Data
@Table(name = "BOOK")
public class BookEntity {
    @Id
    @Column(name = "COMMODITY_ID")
    private String id;

    @Column(name = "COMMODITY_NAME")
    private String bookName;

    @Column(name = "COMMODITY_PRICE")
    private Integer bookPrice;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity author;
}
