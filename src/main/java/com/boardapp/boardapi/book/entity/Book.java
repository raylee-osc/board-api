package com.boardapp.boardapi.book.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.author.entity.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table("book")
public class Book {
    @Id
    @Column("book_id")
    private Long bookId;

    @Column("book_title")
    private String bookTitle;

    @Column("book_description")
    private String bookDescription;

    // @Setter
    // @MappedCollection(idColumn = "author_id", keyColumn = "book_id")
    // List<Author> authorList = new ArrayList<Author>();

    // public void addAuthor(Author author) {
    //     this.authorList.add(author);
    // }

    @Column("author_id")
    private Author authorList;
}
