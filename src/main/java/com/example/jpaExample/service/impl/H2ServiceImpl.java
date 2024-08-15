package com.example.jpaExample.service.impl;

import com.example.jpaExample.data.dto.SetAuthorInfoReqDto;
import com.example.jpaExample.data.dto.SetBookInfoReqDto;
import com.example.jpaExample.data.entity.h2.AuthorEntity;
import com.example.jpaExample.data.entity.h2.BookEntity;
import com.example.jpaExample.data.repository.h2.AuthorRepository;
import com.example.jpaExample.data.repository.h2.BookRepository;
import com.example.jpaExample.service.H2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class H2ServiceImpl implements H2Service {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    @Override
    public Boolean setAuthorInfo(SetAuthorInfoReqDto req){

        AuthorEntity author = new AuthorEntity();
        author.setId(req.getAuthorId());
        author.setAuthorName(req.getAuthorName());

        AuthorEntity persistAuthor = authorRepository.save(author);

        return true;
    }

    @Override
    public Boolean setBookInfo(SetBookInfoReqDto req) {
        AuthorEntity author = new AuthorEntity();
        author.setId(req.getAuthorId());

        BookEntity book = new BookEntity();
        book.setId(req.getBookId());
        book.setBookName(req.getBookName());
        book.setBookPrice(req.getBookPrice());
        book.setAuthor(author);

        BookEntity bookEntity = bookRepository.save(book);
        return true;
    }
}
