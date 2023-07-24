DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;

CREATE TABLE IF NOT EXISTS author(
    id BIGINT NOT NULL AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    author_name VARCHAR(100) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY (book_id, author_name)
);

CREATE TABLE IF NOT EXISTS book(
    book_id BIGINT NOT NULL AUTO_INCREMENT,
    book_title VARCHAR(100) NOT NULL,
    book_description VARCHAR(200) NOT NULL,

    PRIMARY KEY (book_id)
);

ALTER TABLE author
ADD CONSTRAINT FK_AuthorBook
FOREIGN KEY (book_id) REFERENCES book(book_id);