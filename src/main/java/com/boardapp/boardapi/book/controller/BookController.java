package com.boardapp.boardapi.book.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.book.model.Book;
import com.boardapp.boardapi.book.model.BookDto;
import com.boardapp.boardapi.book.service.BookService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public Iterable<Book> getAllBook() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/:{bookId}")
    public Book getByBookId(@PathVariable Long bookId) {
        return this.bookService.getByBookId(bookId);
    }

    @PostMapping
    public Book saveBook(@RequestBody BookDto dto) {
        return this.bookService.saveBook(dto);
    }

    @PutMapping("/:{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody BookDto dto) {
        return this.bookService.updateBook(bookId, dto);
    }

    @DeleteMapping("/:{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        this.bookService.deleteBook(bookId);
    }
}
