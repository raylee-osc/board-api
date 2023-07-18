package com.boardapp.boardapi.user.repository;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.repository.sql.UserSql;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository{
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer saveUser(User user) {
        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(user);

        return this.namedParameterJdbcTemplate.update(UserSql.INSERT_USER, namedParameterSource);
    }

    @Override
    public Integer updateUser(User user) {
        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(user);

        return this.namedParameterJdbcTemplate.update(UserSql.UPDATE_BY_ID, namedParameterSource);
    }

}
