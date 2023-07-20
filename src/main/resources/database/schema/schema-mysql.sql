-- ALTER TABLE board DROP CONSTRAINT FK_BoardWriteUser;
-- ALTER TABLE board DROP CONSTRAINT FK_BoardModifyUser;

DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user(
    index_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    user_password VARCHAR(100) NOT NULL,

    PRIMARY KEY (user_id),
    UNIQUE KEY (index_id)
);

CREATE TABLE IF NOT EXISTS board(
    board_id BIGINT NOT NULL AUTO_INCREMENT,

    board_title VARCHAR(50) NOT NULL,
    board_contents VARCHAR(200) NOT NULL,

    write_id VARCHAR(50) NOT NULL,
    modify_id VARCHAR(50) NULL,

    PRIMARY KEY (board_id)
);

ALTER TABLE board
ADD CONSTRAINT FK_BoardWriteUser
FOREIGN KEY (write_id) REFERENCES user(user_id);

ALTER TABLE board
ADD CONSTRAINT FK_BoardModifyUser
FOREIGN KEY (modify_id) REFERENCES user(user_id);