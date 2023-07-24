DROP TABLE IF EXISTS book_ref;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;

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

CREATE TABLE IF NOT EXISTS book_ref(
    book_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL
);

ALTER TABLE book_ref
ADD CONSTRAINT FK_AuthorBookId
FOREIGN KEY (book_id) REFERENCES book(book_id);

ALTER TABLE book_ref
ADD CONSTRAINT FK_BookAuthorId
FOREIGN KEY (author_id) REFERENCES author(author_id);