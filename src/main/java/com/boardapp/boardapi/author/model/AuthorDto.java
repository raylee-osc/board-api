package com.boardapp.boardapi.author.model;

import java.util.ArrayList;
import java.util.List;
import com.boardapp.boardapi.book.entity.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private List<Book> bookList = new ArrayList<Book>();

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    @Builder
    public AuthorDto(Long id, String name, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.bookList = bookList;
    }
}
