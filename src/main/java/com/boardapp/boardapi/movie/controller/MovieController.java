package com.boardapp.boardapi.movie.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.movie.entity.Movie;
import com.boardapp.boardapi.movie.entity.MoviePrice;
import com.boardapp.boardapi.movie.model.MovieDto;
import com.boardapp.boardapi.movie.repository.MoviePriceRepository;
import com.boardapp.boardapi.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;
    private final MoviePriceRepository moviePriceRepository;

    @GetMapping
    public List<Movie> findAllMovies() {
        Iterable<Movie> entityList = this.movieRepository.findAll();

        List<Movie> dtoList = new ArrayList<>();

        for(Movie entity: entityList) {
            log.warn(entity.getMovieId().toString());
            log.warn(entity.getMovieTitle());
            log.warn(entity.getMovieDescription());
            log.warn(entity.getMoviePrice() == null ? "Null" : "Not Null");
            dtoList.add(entity);
        }

        return dtoList;
    }

    @GetMapping("/price")
    public List<MoviePrice> findAllMoviePriceList() {
        Iterable<MoviePrice> entityList = this.moviePriceRepository.findAll();

        List<MoviePrice> dtoList = new ArrayList<>();

        for(MoviePrice entity: entityList) {
            dtoList.add(entity);
        }

        return dtoList;
    }

    @PostMapping
    public Movie save(@RequestBody MovieDto dto ){
        Movie movie = Movie.builder().movieTitle(dto.getTitle()).movieDescription(dto.getDescription()).build();

        movie.setMoviePrice(MoviePrice.builder().moviePrice(dto.getPrice()).build());

        return this.movieRepository.save(movie);
    }
}
