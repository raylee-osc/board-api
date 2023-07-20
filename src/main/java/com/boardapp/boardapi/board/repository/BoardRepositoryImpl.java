package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;
import com.boardapp.boardapi.board.repository.utils.BoardCustomRowMapper;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsertOperations simpleJdbcInsertOperations;
    private final BoardCustomRowMapper boardCustomRowMapper;

    public BoardRepositoryImpl(
        JdbcTemplate jdbcTemplate,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        BoardCustomRowMapper boardCustomRowMapper
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.boardCustomRowMapper = boardCustomRowMapper;
        this.simpleJdbcInsertOperations = new SimpleJdbcInsert(jdbcTemplate)
                                                .withTableName("board")
                                                .usingColumns("board_title", "board_contents", "write_id", "modify_id", "write_date", "modify_date")
                                                .usingGeneratedKeyColumns("board_id")
                                                .withoutTableColumnMetaDataAccess();
    }

    @Override
    public List<Board> findAll() {
        return this.namedParameterJdbcTemplate.query(BoardSql.SELECT_ALL, boardCustomRowMapper);
    }

    @Override
    public Board findById(Long boardId) {
        SqlParameterSource namedSqlParameter = new MapSqlParameterSource("boardId", boardId);

        return this.namedParameterJdbcTemplate.queryForObject(BoardSql.SELECT_BY_ID, namedSqlParameter, boardCustomRowMapper);
    }

    @Override
    public Integer save(Board board) {
        SqlParameterSource namedSqlParameterSource = new BeanPropertySqlParameterSource(board);

        // ! Using NamedParameterJdbcTemplate
        // return this.namedParameterJdbcTemplate.update(BoardSql.INSERT_BOARD, namedSqlParameterSource);

        // ! Using SimpleJdbcInsert
        return this.simpleJdbcInsertOperations.executeAndReturnKey(namedSqlParameterSource).intValue();
    }

    @Override
    public Integer update(Board board) {
        SqlParameterSource namedSqlParameterSource = new BeanPropertySqlParameterSource(board);

        return this.namedParameterJdbcTemplate.update(BoardSql.UPDATE_BY_ID, namedSqlParameterSource);
    }

    @Override
    public Integer delete(Long boardId) {
        SqlParameterSource namedSqlParameter = new MapSqlParameterSource("boardId", boardId);

        return this.namedParameterJdbcTemplate.update(BoardSql.DELETE_BY_ID, namedSqlParameter);
    }

}
