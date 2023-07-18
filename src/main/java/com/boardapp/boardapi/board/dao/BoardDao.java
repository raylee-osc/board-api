package com.boardapp.boardapi.board.dao;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardDao {
    public List<Board> findAll();

    public Board findById(Long boardId);

    public void save(Board board);

    public void update(Board board);

    public void delete(Long boardId);
}
