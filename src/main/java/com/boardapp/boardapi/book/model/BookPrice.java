package com.boardapp.boardapi.book.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Table("book_price_tb")
public class BookPrice {
    @Column("book_price_id")
    @JsonBackReference
    private Long bookPriceId;

    @Column("book_price")
    private final Integer bookPrice;
}
