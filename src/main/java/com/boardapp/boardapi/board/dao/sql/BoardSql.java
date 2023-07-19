package com.boardapp.boardapi.board.dao.sql;

public class BoardSql {
    public static final String SELECT_ALL = """
            SELECT *
            FROM board
            """;

    public static final String SELECT_BY_ID = """
            SELECT *
            FROM board
            WHERE board_id = ?
            """;

    public static final String INSERT_BOARD = """
            INSERT
            INTO board(
                board_title,
                board_contents,
                write_id,
                write_date
            ) VALUES(
                ?,
                ?,
                ?,
                ?
            )
            """;

    public static final String UPDATE_BY_ID = """
            UPDATE board
            SET board_title = ?,
                board_contents = ?,
                modify_id = ?,
                modify_date = ?
            WHERE board_id = ?
            """;

    public static final String DELETE_BY_ID = """
            DELETE
            FROM board
            WHERE board_id = ?
            """;
}