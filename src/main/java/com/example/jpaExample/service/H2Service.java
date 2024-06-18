package com.example.jpaExample.service;
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

import com.example.jpaExample.data.dto.SetAuthorInfoReqDto;
import com.example.jpaExample.data.dto.SetBookInfoReqDto;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : H2Service
 * @Date : 2024-03-05
 * @description :
 */
public interface H2Service {
    public Boolean setAuthorInfo(SetAuthorInfoReqDto req);

    public Boolean setBookInfo(SetBookInfoReqDto req);
}
