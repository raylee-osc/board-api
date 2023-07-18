package com.boardapp.boardapi.user.repository.sql;

public class UserSql {
    public static final String INSERT_USER = """
            INSERT
            INTO user(
                user_id,
                user_name,
                user_password,
                user_phonenumber,
                created_date
            ) VALUES(
                :userId,
                :userName,
                :userPassword,
                :userPhonenumber,
                :createdDate
            )
            """;

    public static final String UPDATE_BY_ID = """
            UPDATE user
            SET user_name = :userName,
                user_password = :userPassword,
                user_phonenumber = :userPhonenumber,
                modified_date = :modifiedDate
            WHERE user_id = :userId
            """;
}
