package com.boardapp.boardapi.board.dao;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardDao {
    public List<Board> findAll();

    public Board findById(Long boardId);

    public Integer save(Board board);

    public Integer update(Board board);

    public Integer delete(Long boardId);
}
