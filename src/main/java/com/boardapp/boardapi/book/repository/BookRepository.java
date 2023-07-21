package com.boardapp.boardapi.book.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.book.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}
