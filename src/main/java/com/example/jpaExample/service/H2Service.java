package com.example.jpaExample.service;

import com.example.jpaExample.data.dto.SetAuthorInfoReqDto;
import com.example.jpaExample.data.dto.SetBookInfoReqDto;

public interface H2Service {
    public Boolean setAuthorInfo(SetAuthorInfoReqDto req);

    public Boolean setBookInfo(SetBookInfoReqDto req);
}
