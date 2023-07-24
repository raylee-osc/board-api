package com.boardapp.boardapi.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String description;
    private Integer price;

    public Book toEntity() {
        return Book.builder()
                    .bookTitle(this.title)
                    .bootDescription(this.description)
                    .bookPrice(new BookPrice(price))
                    .build();
    }

    public Book toEntity(Long bookId) {
        return Book.builder()
                    .bookId(bookId)
                    .bookTitle(this.title)
                    .bootDescription(this.description)
                    .bookPrice(new BookPrice(price))
                    .build();
    }
}
