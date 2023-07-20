package com.boardapp.boardapi.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Iterable<Board> findAll() {
        return this.boardRepository.findAll();
    }

    public Board findById(Long boardId) {
        return this.boardRepository.findById(boardId).get();
    }

    @Transactional
    public Board saveBoard(Board dto) {
        return this.boardRepository.save(dto);
    }

    @Transactional
    public Integer updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);

        return this.boardRepository.update(dto);
    }

    @Transactional
    public void deleteBoard(Long boardId){
        this.boardRepository.deleteById(boardId);
    }
}
