package com.example.jpaExample.controller;

import com.example.jpaExample.data.dto.SetAuthorInfoReqDto;
import com.example.jpaExample.service.PgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
