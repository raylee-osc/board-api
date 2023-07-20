package com.boardapp.boardapi.movie.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.movie.entity.MoviePrice;

public interface MoviePriceRepository extends CrudRepository<MoviePrice, Long>{
    
}
