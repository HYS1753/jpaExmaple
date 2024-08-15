package com.example.jpaExample.service.impl;

import com.example.jpaExample.data.dto.SetAuthorInfoReqDto;
import com.example.jpaExample.data.dto.SetBookInfoReqDto;
import com.example.jpaExample.data.entity.pg.AuthorPgEntity;
import com.example.jpaExample.data.repository.pg.AuthorRepositoryPg;
import com.example.jpaExample.service.PgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


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
