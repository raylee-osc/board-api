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
    public Board saveBoard(Board board) {
        return this.boardRepository.save(board);
    }

    @Transactional
    public Board updateBoard(Long boardId, Board board) {
        String writeId = this.boardRepository.findById(boardId).get().getWriteId();

        board.setBoardId(boardId);
        board.setWriteId(writeId);

        return this.boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Long boardId){
        this.boardRepository.deleteById(boardId);
    }
}
