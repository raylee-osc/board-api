package com.boardapp.boardapi.book.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("book_tb")
public class Book {
    @Setter
    @Id
    @Column("book_id")
    private Long bookId;
    
    @Column("book_title")
    private String bookTitle;

    @Column("book_description")
    private String bootDescription;

    @Column("book_price_id")
    private BookPrice bookPrice;
}
