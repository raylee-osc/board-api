DROP TABLE IF EXISTS book_ref;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;

CREATE TABLE IF NOT EXISTS author(
    -- author_id BIGINT NOT NULL AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    author_name VARCHAR(100) NOT NULL,

    -- PRIMARY KEY (author_id),
    PRIMARY KEY (book_id, author_name)
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

-- ALTER TABLE book
-- ADD CONSTRAINT FK_BookAuthor
-- FOREIGN KEY (book_id) REFERENCES author(author_id);


-- CREATE TABLE IF NOT EXISTS book_ref(
--     book_id BIGINT NOT NULL,
--     author_id BIGINT NOT NULL
-- );

-- ALTER TABLE book_ref
-- ADD CONSTRAINT FK_AuthorBookId
-- FOREIGN KEY (book_id) REFERENCES book(book_id);

-- ALTER TABLE book_ref
-- ADD CONSTRAINT FK_BookAuthorId
-- FOREIGN KEY (author_id) REFERENCES author(author_id);