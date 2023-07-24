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

    public Author getByAuthorId(Long id) {
        return this.authorRepository.findById(id).orElse(new Author());
    }

    public Author saveAuthor(Author dto) {
        return this.authorRepository.save(dto);
    }

    public Author updateAuthor(Long id, Author dto) {
        dto.setIndex(id);

        return this.authorRepository.save(dto);
    }

    public void deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }
}
