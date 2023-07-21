DROP TABLE IF EXISTS book_tb;
DROP TABLE IF EXISTS book_price_tb;

CREATE TABLE IF NOT EXISTS book_tb(
    book_id BIGINT NOT NULL AUTO_INCREMENT,
    book_title VARCHAR(50) NOT NULL,
    book_description VARCHAR(100) NOT NULL,

    PRIMARY KEY (book_id)
);

CREATE TABLE IF NOT EXISTS book_price_tb(
    book_price_id BIGINT NOT NULL AUTO_INCREMENT,
    book_price INT NOT NULL,

    PRIMARY KEY (book_price_id)
);

-- ALTER TABLE book_tb
-- ADD CONSTRAINT FK_BookPrice
-- FOREIGN KEY book_price REFERENCES book_price_tb (book_price)