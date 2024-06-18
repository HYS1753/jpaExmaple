package com.example.jpaExample.controller;
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
import com.example.jpaExample.service.PgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : PgController
 * @Date : 2024-03-07
 * @description :
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pg")
public class PgController {
    private final PgService service;

    @GetMapping(value = "/setAuthorInfo")
    public ResponseEntity<Boolean> setAuthorInfo(@ModelAttribute SetAuthorInfoReqDto req) {
        log.debug("========================= setAuthor Start: " + req.toString());
        return ResponseEntity.ok().body(service.setAuthorInfo(req));
    }
}
