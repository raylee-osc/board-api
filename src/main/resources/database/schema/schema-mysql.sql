DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_info;

CREATE TABLE IF NOT EXISTS user(
    user_id VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    user_info BIGINT NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS user_info(
    index_id BIGINT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    user_email VARCHAR(100) NOT NULL,
    user_phonenumber VARCHAR(100) NOT NULL,

    PRIMARY KEY (index_id)
);

ALTER TABLE user
ADD CONSTRAINT FK_UserInfoUser
FOREIGN KEY (user_info) REFERENCES user_info(index_id);

