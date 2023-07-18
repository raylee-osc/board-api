package com.boardapp.boardapi.board.service;

import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.dao.BoardDao;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardDao boardDao;

    @Override
    public List<Board> findAllBoards() {
        return this.boardDao.findAll();
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.boardDao.findById(boardId);
    }

    @Override
    public void saveBoard(Board dto) {
        dto.setWriteDate(new Date(System.currentTimeMillis()));

        this.boardDao.save(dto);
    }

    @Override
    public void updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);
        dto.setModifyDate(new Date(System.currentTimeMillis()));

        this.boardDao.update(dto);
    }

    @Override
    public void deleteBoard(Long boardId) {
        this.boardDao.delete(boardId);
    }

}
