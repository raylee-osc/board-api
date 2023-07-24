package com.boardapp.boardapi.book.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.book.model.Book;
import com.boardapp.boardapi.book.model.BookDto;
import com.boardapp.boardapi.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        Iterable<Book> entityList = this.bookRepository.findAll();

        List<BookDto> dtoList = new ArrayList<BookDto>();

        for(Book entity : entityList) {
            dtoList.add(entity.toDto());
        }

        return dtoList;
    }

    public BookDto getByBookId(Long bookId) {
        return this.bookRepository.findById(bookId).orElse(new Book()).toDto();
    }

    public BookDto saveBook(BookDto dto) {
        return this.bookRepository.save(dto.toEntity()).toDto();
    }

    public BookDto updateBook(Long bookId, BookDto dto) {
        return this.bookRepository.save(dto.toEntity(bookId)).toDto();
    }

    public void deleteBook(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }
}
