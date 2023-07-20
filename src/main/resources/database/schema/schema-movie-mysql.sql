ALTER TABLE movie_price DROP CONSTRAINT FK_MoviePriceMovie;

DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS movie_price;

CREATE TABLE IF NOT EXISTS movie(
    movie_id BIGINT NOT NULL AUTO_INCREMENT,
    movie_title VARCHAR(100) NOT NULL,
    movie_description VARCHAR(200) NOT NULL,

    PRIMARY KEY (movie_id)
);

CREATE TABLE IF NOT EXISTS movie_price(
    movie_id BIGINT NOT NULL,
    movie_price INT NOT NULL,
    PRIMARY KEY (movie_id)
);

ALTER TABLE movie_price
ADD CONSTRAINT FK_MoviePriceMovie
FOREIGN KEY (movie_id) REFERENCES movie (movie_id);