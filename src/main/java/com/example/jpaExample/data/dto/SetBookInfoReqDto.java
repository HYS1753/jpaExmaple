package com.example.jpaExample.data.dto;
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

import lombok.Data;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : SetBookInfoReqDto
 * @Date : 2024-03-07
 * @description :
 */
@Data
public class SetBookInfoReqDto {
    private String bookId;
    private String bookName;
    private Integer bookPrice;
    private String authorId;
}
