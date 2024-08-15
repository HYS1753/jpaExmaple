package com.example.jpaExample.data.entity.h2;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "BOOK")
public class BookEntity {
    @Id
    @Column(name = "COMMODITY_ID")
    private String id;

    @Column(name = "COMMODITY_NAME")
    private String bookName;

    @Column(name = "COMMODITY_PRICE")
    private Integer bookPrice;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity author;
}
