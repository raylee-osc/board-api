package com.boardapp.boardapi.book.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.book.model.Book;
import com.boardapp.boardapi.book.model.BookDto;
import com.boardapp.boardapi.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Iterable<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book getByBookId(Long bookId) {
        return this.bookRepository.findById(bookId).orElse(new Book());
    }

    public Book saveBook(BookDto dto) {
        return this.bookRepository.save(dto.toEntity());
    }

    public Book updateBook(Long bookId, BookDto dto) {
        return this.bookRepository.save(dto.toEntity(bookId));
    }

    public void deleteBook(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }
}
