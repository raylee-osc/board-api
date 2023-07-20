package com.boardapp.boardapi.board.repository;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardRepository {
    List<Board> findAll();

    Board findById(Long boardId);

    Integer save(Board board);

    Integer update(Board board);

    Integer delete(Long boardId);
}
