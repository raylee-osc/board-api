package com.boardapp.boardapi.board.service;

import java.util.List;
import java.util.Map;
import com.boardapp.boardapi.board.model.Board;

public interface BoardService {
    List<Board> findAllByCustomQuery(Map<String, String> allParams);

    Board findByCustomQuery(Map<String, String> allParams);

    Integer saveBoard(Board dto);

    Integer updateBoard(Long boardId, Board dto);

    Integer deleteBoard(Map<String, String> param);
}
