package com.boardapp.boardapi.movie.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.movie.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie,Long>{
    
}
