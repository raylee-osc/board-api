package com.boardapp.boardapi.author.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.author.entity.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{
    
}
