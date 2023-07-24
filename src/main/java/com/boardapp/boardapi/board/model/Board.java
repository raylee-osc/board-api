package com.boardapp.boardapi.board.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("board")
public class Board {
    @Id
    @Setter
    @Column("board_id")
    private Long boardId;

    @Column("board_title")
    private String boardTitle;

    @Column("board_contents")
    private String boardContents;

    @Column("write_id")
    private String writeId;

    @Column("modify_id")
    private String modifyId;
}
