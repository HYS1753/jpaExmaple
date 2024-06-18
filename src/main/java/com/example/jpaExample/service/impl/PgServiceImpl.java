package com.example.jpaExample.service.impl;
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
import com.example.jpaExample.data.dto.SetBookInfoReqDto;
import com.example.jpaExample.data.entity.pg.AuthorPgEntity;
import com.example.jpaExample.data.repository.pg.AuthorRepositoryPg;
import com.example.jpaExample.service.PgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : PgServiceImpl
 * @Date : 2024-03-07
 * @description :
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PgServiceImpl implements PgService {
    private final AuthorRepositoryPg authorRepository;

    public Boolean setAuthorInfo(SetAuthorInfoReqDto req) {
        AuthorPgEntity author = new AuthorPgEntity();
        author.setId(req.getAuthorId());
        author.setAuthorName(req.getAuthorName());

        AuthorPgEntity persistAuthor = authorRepository.save(author);

        return true;
    }
}
