CREATE DATABASE IF NOT EXISTS data_jdbc;

-- Drop Constraints
ALTER TABLE board DROP CONSTRAINT writer;
ALTER TABLE board DROP CONSTRAINT modifier;

-- Drop Tables
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS board;

-- Create Table `user`
CREATE TABLE IF NOT EXISTS user (
    index_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    user_name VARCHAR(40) NOT NULL,
    user_password VARCHAR(60) NOT NULL,
    user_phonenumber VARCHAR(50) NOT NULL,
    created_date DATETIME NOT NULL,
    modified_date DATETIME NULL,

    PRIMARY KEY (user_id),

    UNIQUE KEY (index_id)
);

-- Create Table `board`
CREATE TABLE IF NOT EXISTS board (
    board_id BIGINT NOT NULL AUTO_INCREMENT,
    board_title VARCHAR(50) NOT NULL,
    board_contents VARCHAR(200) NOT NULL,
    write_id VARCHAR(50) NOT NULL,
    modify_id VARCHAR(50) NULL,
    write_date DATETIME NOT NULL,
    modify_date DATETIME NULL,

    PRIMARY KEY (board_id),

    CONSTRAINT writer FOREIGN KEY (write_id) REFERENCES user(user_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT modifier FOREIGN KEY (modify_id) REFERENCES user(user_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);