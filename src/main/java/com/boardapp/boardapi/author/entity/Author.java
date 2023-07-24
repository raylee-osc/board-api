package com.boardapp.boardapi.author.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("author")
public class Author {
    @Id
    @Column("author_id")
    private Long authorId;

    @Column("author_name")
    private String authorName;
}
