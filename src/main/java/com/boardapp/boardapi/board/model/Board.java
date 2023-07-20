package com.boardapp.boardapi.board.model;


import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Board {
    @Setter
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String writeId;
    private String modifyId;

    @Setter
    private Date writeDate;

    @Setter
    private Date modifyDate;
}