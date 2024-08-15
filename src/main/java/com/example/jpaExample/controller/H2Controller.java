package com.example.jpaExample.controller;

import com.example.jpaExample.data.dto.SetAuthorInfoReqDto;
import com.example.jpaExample.data.dto.SetBookInfoReqDto;
import com.example.jpaExample.service.H2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
