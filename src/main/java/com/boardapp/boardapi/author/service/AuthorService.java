package com.boardapp.boardapi.author.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.author.entity.Author;
import com.boardapp.boardapi.author.model.AuthorDto;
import com.boardapp.boardapi.author.repository.AuthorRepository;
import com.boardapp.boardapi.book.entity.Book;
import com.boardapp.boardapi.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<AuthorDto> getAllAuthor() {
        Iterable<Author> entityList = this.authorRepository.findAll();

        List<AuthorDto> dtoList = new ArrayList<AuthorDto>();

        for(Author entity : entityList) {

            List<Book> bookList = new ArrayList<Book>();
            
            entity.getAuthorRefs().forEach(ref -> {
                bookList.add(this.bookRepository.findById(ref.getBookId()).get());
            });

            AuthorDto dto = AuthorDto.builder().id(entity.getAuthorId()).name(entity.getAuthorName()).bookList(bookList).build();

            dtoList.add(dto);
        }

        // return this.authorRepository.findAll();
        return dtoList;
    }

    public Author getByAuthorId(Long id) {
        return this.authorRepository.findById(id).orElse(new Author());
    }

    public Author saveAuthor(Author dto) {
        return this.authorRepository.save(dto);
    }

    public Author updateAuthor(Long id, Author dto) {
        dto.setAuthorId(id);

        return this.authorRepository.save(dto);
    }

    public void deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }
}
