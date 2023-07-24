INSERT INTO book(book_title, book_description) VALUES ("Adventure Book","Funny description : Lorem ipsum si amet ...");

-- INSERT INTO author(author_name) VALUES ("RayLee");
-- INSERT INTO author(author_name) VALUES ("Tester");
INSERT INTO author(book_id, author_name) VALUES (1,"RayLee");
INSERT INTO author(book_id, author_name) VALUES (1,"Tester");

-- INSERT INTO book_ref(book_id,author_id) VALUES (1,1);