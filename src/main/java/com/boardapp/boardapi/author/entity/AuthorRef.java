package com.boardapp.boardapi.author.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;

@Getter
@Table("book_author")
public class AuthorRef {
    @Column("author_id")
    private Long authorId;

    @Column("book_id")
    private Long bookId;
}
