INSERT INTO user(
    user_id, 
    user_name,
    user_email,
    user_password
) VALUES (
    "UserId1",
    "Merry",
    "user1@gmail.com",
    "01234"
);

INSERT INTO user(
    user_id, 
    user_name,
    user_email,
    user_password
) VALUES (
    "UserId2",
    "John",
    "user2@gmail.com",
    "56789"
);

INSERT INTO board(
    board_title,
    board_contents,
    write_id
) VALUES (
    "Test Title1",
    "Test Contents1",
    "UserId1"
);

INSERT INTO board(
    board_title,
    board_contents,
    write_id
) VALUES (
    "Test Title2",
    "Test Contents2",
    "UserId2"
);

INSERT INTO board(
    board_title,
    board_contents,
    write_id,
    modify_id
) VALUES (
    "Test Title1",
    "Test Contents1",
    "UserId2",
    "UserId1"
);