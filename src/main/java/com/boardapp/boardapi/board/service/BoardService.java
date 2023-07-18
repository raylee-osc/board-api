package com.boardapp.boardapi.board.service;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardService {
    List<Board> findAllBoards();

    Board findByBoardId(Long boardId);

    void saveBoard(Board dto);

    void updateBoard(Long boardId, Board dto);

    void deleteBoard(Long boardId);
}
