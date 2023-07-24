package com.boardapp.boardapi.author.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.author.entity.Author;
import com.boardapp.boardapi.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Iterable<Author> getAllAuthor() {
        return this.authorRepository.findAll();
    }

    public Author getByAuthorId(Long authorId) {
        return this.authorRepository.findById(authorId).orElse(new Author());
    }

    public Author saveAuthor(Author dto) {
        return this.authorRepository.save(dto);
    }

    public Author updateAuthor(Long authorId, Author dto) {
        return this.authorRepository.save(dto);
    }

    public void deleteAuthor(Long authorId) {
        this.authorRepository.deleteById(authorId);
    }
}
