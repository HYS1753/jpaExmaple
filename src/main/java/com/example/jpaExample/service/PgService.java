package com.example.jpaExample.service;
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

import com.example.jpaExample.data.dto.SetAuthorInfoReqDto;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : PgService
 * @Date : 2024-03-07
 * @description :
 */
public interface PgService {

    public Boolean setAuthorInfo(SetAuthorInfoReqDto req);
}
