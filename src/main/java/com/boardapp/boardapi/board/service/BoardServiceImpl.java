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
    public Integer saveBoard(Board dto) {
        dto.setWriteDate(new Date(System.currentTimeMillis()));

        return this.boardDao.save(dto);
    }

    @Override
    public Integer updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);
        dto.setModifyDate(new Date(System.currentTimeMillis()));

        return this.boardDao.update(dto);
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.boardDao.delete(boardId);
    }

}