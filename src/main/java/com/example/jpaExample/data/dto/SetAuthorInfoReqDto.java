package com.example.jpaExample.data.dto;
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

import lombok.Data;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : SetAuthorInfoReqDto
 * @Date : 2024-03-05
 * @description :
 */
@Data
public class SetAuthorInfoReqDto {
    private String authorId;
    private String authorName;
}
