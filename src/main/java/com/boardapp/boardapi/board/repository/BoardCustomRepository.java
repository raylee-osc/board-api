package com.boardapp.boardapi.board.repository;

import com.boardapp.boardapi.board.model.Board;

public interface BoardCustomRepository {
    Integer update(Board board);
}
