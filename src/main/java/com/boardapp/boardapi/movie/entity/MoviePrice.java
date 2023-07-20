package com.boardapp.boardapi.movie.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("movie_price")
public class MoviePrice {
    @Id
    @Column("movie_id")
    private Long movieId;

    @Column("movie_price")
    private Integer moviePrice;
}
