package com.boardapp.boardapi.board.repository;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository{
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer update(Board board) {
        SqlParameterSource namedSqlParameterSource = new BeanPropertySqlParameterSource(board);

        return this.namedParameterJdbcTemplate.update(BoardSql.UPDATE_BY_ID, namedSqlParameterSource);
    }
}
