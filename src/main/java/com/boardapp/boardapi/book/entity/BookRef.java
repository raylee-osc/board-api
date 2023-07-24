package com.boardapp.boardapi.book.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("book_ref")
public class BookRef {
    @Column("book_id")
    private Long bookId;

    @Column("author_id")
    private Long authorId;
}
