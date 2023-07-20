package com.boardapp.boardapi.board.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Table("board")
public class Board {
    @Id
    @Column("board_id")
    @Setter
    private Long boardId;

    @Column("board_title")
    private String boardTitle;

    @Column("board_contents")
    private String boardContents;

    @Column("write_id")
    @Setter
    private String writeId;

    @Setter
    @Column("write_id")
    private User writer;

    @Column("modify_id")
    private String modifyId;

    @Setter
    @Column("modify_id")
    private User modifier;
}
