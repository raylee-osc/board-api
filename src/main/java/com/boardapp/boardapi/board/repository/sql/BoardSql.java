package com.boardapp.boardapi.board.repository.sql;

public class BoardSql {
    public final static String SELECT_ALL = """
                    SELECT *
                    FROM board
                    """;

    public final static String SELECT_BY_ID = """
                    SELECT *
                    FROM board
                    WHERE board_id = ?
                    """;

    public final static String INSERT_BOARD = """
                    INSERT
                    INTO board(
                        board_title,
                        board_contents,
                        write_id,
                        write_date
                    ) VALUES(?, ?, ?, ?)
                    """;

    public final static String UPDATE_BY_ID = """
                    UPDATE board
                    SET board_title = ?,
                        board_contents = ?,
                        modify_id = ?,
                        modify_date = ?
                    WHERE board_id = ?
                    """;

    public final static String DELETE_BY_ID = """
                    DELETE
                    FROM board
                    WHERE board_id = ?
                    """;
}
