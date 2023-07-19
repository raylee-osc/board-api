package com.boardapp.boardapi.board.dao;

import java.util.List;
import java.util.Map;
import com.boardapp.boardapi.board.model.Board;

public interface BoardDao {
    public List<Board> findAllByCustomQuery(Map<String, String> allParams);

    public Board findByCustomQuery(Map<String, String> allParams);

    public Integer saveBoard(Board board);

    public Integer updateBoard(Board board);

    public Integer deleteByCustomQuery(Map<String, String> param);
}
