package com.boardapp.boardapi.book.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.book.model.BookDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Setter
    @MappedCollection(idColumn = "book_id",keyColumn = "book_id")
    private List<BookRef> bookRefs = new ArrayList<BookRef>();

    public void addBookRef(BookRef bookRef) {
        this.bookRefs.add(bookRef);
    }

    public BookDto toDto() {
        return BookDto.builder()
                        .id(this.bookId)
                        .title(this.bookTitle)
                        .description(this.bookDescription)
                        .build();
    }
}
