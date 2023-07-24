DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;

CREATE TABLE IF NOT EXISTS author(
    author_id BIGINT NOT NULL AUTO_INCREMENT,
    author_name VARCHAR(100) NOT NULL,

    PRIMARY KEY (author_id)
);

CREATE TABLE IF NOT EXISTS book(
    book_id BIGINT NOT NULL AUTO_INCREMENT,
    book_title VARCHAR(100) NOT NULL,
    book_description VARCHAR(200) NOT NULL,

    PRIMARY KEY (book_id)
);

CREATE TABLE IF NOT EXISTS book_author(
    author_id BIGINT,
    book_id BIGINT,

    PRIMARY KEY (author_id, book_id)
);

ALTER TABLE book_author
ADD CONSTRAINT FK_AuthorId
FOREIGN KEY (author_id) REFERENCES author(author_id);

ALTER TABLE book_author
ADD CONSTRAINT FK_BookId
FOREIGN KEY (book_id) REFERENCES book(book_id);