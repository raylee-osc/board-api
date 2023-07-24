package com.boardapp.boardapi.book.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.author.entity.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Table("book")
public class Book {
    @Id
    @Setter
    @Column("book_id")
    private Long bookId;

    @Column("book_title")
    private String bookTitle;

    @Column("book_description")
    private String bookDescription;

    @Column("book_id")
    private Author bookAuthor;
}
