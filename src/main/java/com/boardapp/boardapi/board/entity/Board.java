package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.board.model.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class Board {
    @Id
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

    @CreatedDate
    @Column("write_date")
    private Date writeDate;

    @LastModifiedDate
    @Column("modify_date")
    private Date modifyDate;

    public BoardDto toDto() {
        return BoardDto.builder()
                        .num(this.boardId)
                        .title(this.boardTitle)
                        .contents(this.boardContents)
                        .writeId(this.writeId)
                        .modifyId(this.modifyId)
                        .writeDate(this.writeDate)
                        .modifyDate(this.modifyDate)
                        .build();
    }
}
