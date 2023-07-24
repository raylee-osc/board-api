package com.boardapp.boardapi.author.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("author")
public class Author{
    @Id
    @Setter
    @Column("id")
    private Long index;

    @Column("book_id")
    private Long bookId;

    @Column("author_name")
    private String authorName;
}
