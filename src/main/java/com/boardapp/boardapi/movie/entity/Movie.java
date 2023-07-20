package com.boardapp.boardapi.movie.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("movie")
public class Movie {
    @Id
    @Column("movie_id")
    private Long movieId;

    @Column("movie_title")
    private String movieTitle;

    @Column("movie_description")
    private String movieDescription;

    @Setter
    @Column("movie_id")
    private MoviePrice moviePrice;
}
