INSERT INTO book(book_title, book_description) VALUES ("Adventure Book","Funny description : Lorem ipsum si amet ...");
INSERT INTO book(book_title, book_description) VALUES ("Science Book","Description : Lorem ipsum si amet ...");

INSERT INTO author(author_name) VALUES ("RayLee");
INSERT INTO author(author_name) VALUES ("Tester");

INSERT INTO book_author(author_id, book_id) VALUES (1,1);
INSERT INTO book_author(author_id, book_id) VALUES (1,2);
INSERT INTO book_author(author_id, book_id) VALUES (2,2);