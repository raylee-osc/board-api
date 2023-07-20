package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Board> boardMapper = BeanPropertyRowMapper.newInstance(Board.class);

    @Override
    public List<Board> findAll() {
        return this.jdbcTemplate.query(BoardSql.SELECT_ALL, boardMapper);
    }

    @Override
    public Board findById(Long boardId) {
        return this.jdbcTemplate.queryForObject(BoardSql.SELECT_BY_ID, boardMapper, boardId);
    }

    @Override
    public Integer save(Board board) {
        return this.jdbcTemplate.update(BoardSql.INSERT_BOARD, board.getBoardTitle(), board.getBoardContents(), board.getWriteId(), board.getWriteDate());
    }

    @Override
    public Integer update(Board board) {
        return this.jdbcTemplate.update(BoardSql.UPDATE_BY_ID, board.getBoardTitle(), board.getBoardContents(), board.getModifyId(), board.getModifyDate(), board.getBoardId());
    }

    @Override
    public Integer delete(Long boardId) {
        return this.jdbcTemplate.update(BoardSql.DELETE_BY_ID, boardId);
    }

}
