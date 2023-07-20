package com.boardapp.boardapi.board.repository.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.boardapp.boardapi.board.model.Board;

@Component
public class BoardCustomRowMapper implements RowMapper<Board>{
    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Board.builder()
                    .boardId(rs.getLong("board_id"))
                    .boardTitle(rs.getString("board_title"))
                    .boardContents(rs.getString("board_contents"))
                    .writeId(rs.getString("write_id"))
                    .modifyId(rs.getString("modify_id"))
                    .writeDate(rs.getDate("write_date"))
                    .modifyDate(rs.getDate("modify_date"))
                    .build();
    }
}
