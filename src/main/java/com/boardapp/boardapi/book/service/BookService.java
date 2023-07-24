package com.boardapp.boardapi.book.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.book.entity.Book;
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

    public Book saveBook(Book dto) {
        return this.bookRepository.save(dto);
    }

    public Book updateBook(Long bookId, Book dto) {
        return this.bookRepository.save(dto);
    }

    public void deleteBook(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }
}
