package com.example.jpaExample.data.dto;

import lombok.Data;

@Data
public class SetBookInfoReqDto {
    private String bookId;
    private String bookName;
    private Integer bookPrice;
    private String authorId;
}
