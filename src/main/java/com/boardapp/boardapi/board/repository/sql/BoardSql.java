package com.boardapp.boardapi.board.repository.sql;

public class BoardSql {
    public final static String SELECT_ALL = """
                    SELECT *
                    FROM board
                    """;

    public final static String SELECT_BY_ID = """
                    SELECT *
                    FROM board
                    WHERE board_id = :boardId
                    """;

    public final static String INSERT_BOARD = """
                    INSERT
                    INTO board(
                        board_title,
                        board_contents,
                        write_id,
                        write_date
                    ) VALUES(
                        :boardTitle,
                        :boardContents,
                        :writeId,
                        :writeDate
                    )
                    """;

    public final static String UPDATE_BY_ID = """
                    UPDATE board
                    SET board_title = :boardTitle,
                        board_contents = :boardContents,
                        modify_id = :modifyId,
                        modify_date = :modifyDate
                    WHERE board_id = :boardId
                    """;

    public final static String DELETE_BY_ID = """
                    DELETE
                    FROM board
                    WHERE board_id = :boardId
                    """;
}
