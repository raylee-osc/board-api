package com.boardapp.boardapi.author.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.author.entity.Author;
import com.boardapp.boardapi.author.model.AuthorDto;
import com.boardapp.boardapi.author.service.AuthorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthor() {
        return this.authorService.getAllAuthor();
    }

    @GetMapping("/:{id}")
    public Author getByAuthorId(@PathVariable Long id) {
        return this.authorService.getByAuthorId(id);
    }

    @PostMapping
    public Author saveAuthor(@RequestBody Author dto) {
        return this.authorService.saveAuthor(dto);
    }

    @PutMapping("/:{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author dto) {
        return this.authorService.updateAuthor(id, dto);
    }

    @DeleteMapping("/:{id}")
    public void deleteAuthor(@PathVariable Long id) {
        this.authorService.deleteAuthor(id);
    }
}
