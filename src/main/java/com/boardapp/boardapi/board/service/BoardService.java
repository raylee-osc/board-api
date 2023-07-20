package com.boardapp.boardapi.board.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService{
    private final BoardRepository boardRepository;

    public List<Board> findAllBoards() {
        return this.boardRepository.findAll();
    }

    public Board findByBoardId(Long boardId) {
        return this.boardRepository.findById(boardId);
    }

    @Transactional
    public Integer saveBoard(Board dto) {
        dto.setWriteDate(Timestamp.valueOf(LocalDateTime.now()));

        return this.boardRepository.save(dto);
    }

    @Transactional
    public Integer updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);
        dto.setModifyDate(Timestamp.valueOf(LocalDateTime.now()));

        return this.boardRepository.update(dto);
    }

    @Transactional
    public Integer deleteBoard(Long boardId) {
        return this.boardRepository.delete(boardId);
    }
}