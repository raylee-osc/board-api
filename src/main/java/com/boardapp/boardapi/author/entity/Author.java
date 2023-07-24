package com.boardapp.boardapi.author.entity;

import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("author")
public class Author{
    @Column("book_id")
    private Long bookId;

    @Column("author_name")
    private String authorName;
}
