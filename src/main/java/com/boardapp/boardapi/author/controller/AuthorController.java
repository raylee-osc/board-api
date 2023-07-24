package com.boardapp.boardapi.author.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.author.entity.Author;
import com.boardapp.boardapi.author.service.AuthorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public Iterable<Author> getAllAuthor() {
        return this.authorService.getAllAuthor();
    }

    @GetMapping("/:{authorId}")
    public Author getByAuthorId(@PathVariable Long authorId) {
        return this.authorService.getByAuthorId(authorId);
    }

    @PostMapping
    public Author saveAuthor(@RequestBody Author dto) {
        return this.authorService.saveAuthor(dto);
    }

    @PutMapping("/:{authorId}")
    public Author updateAuthor(@PathVariable Long authorId, @RequestBody Author dto) {
        return this.authorService.updateAuthor(authorId, dto);
    }

    @DeleteMapping("/:{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        this.authorService.deleteAuthor(authorId);
    }
}
