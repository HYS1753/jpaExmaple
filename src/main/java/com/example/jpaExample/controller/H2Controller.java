package com.example.jpaExample.controller;
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
import com.example.jpaExample.service.H2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : H2Controller
 * @Date : 2024-03-05
 * @description :
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/h2")
public class H2Controller {
    private final H2Service service;

    @GetMapping(value = "/setAuthorInfo")
    public ResponseEntity<Boolean> setAuthorInfo(@ModelAttribute SetAuthorInfoReqDto req) {
        log.debug("========================= setAuthor Start: " + req.toString());
        return ResponseEntity.ok().body(service.setAuthorInfo(req));
    }

    @GetMapping(value = "/setBookInfo")
    public ResponseEntity<Boolean> setBookInfo(@ModelAttribute SetBookInfoReqDto req) {
        log.debug("========================= setBook Start: " + req.toString());
        return ResponseEntity.ok().body(service.setBookInfo(req));
    }
}
