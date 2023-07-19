package com.boardapp.boardapi.board.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.dao.BoardDao;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardDao boardDao;

    @Override
    public List<Board> findAllByCustomQuery(Map<String, String> allParams) {
        return this.boardDao.findAllByCustomQuery(allParams);
    }

    @Override
    public Board findByCustomQuery(Map<String, String> allParams) {
        return this.boardDao.findByCustomQuery(allParams);
    }

    @Override
    @Transactional
    public Integer saveBoard(Board dto) {
        dto.setWriteDate(LocalDateTime.now());

        return this.boardDao.saveBoard(dto);
    }

    @Override
    @Transactional
    public Integer updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);
        dto.setModifyDate(LocalDateTime.now());

        return this.boardDao.updateBoard(dto);
    }

    @Override
    @Transactional
    public Integer deleteBoard(Map<String, String> param) {
        return this.boardDao.deleteByCustomQuery(param);
    }
}
