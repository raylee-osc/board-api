package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public List<BoardDto> findAllBoards() {
        Iterable<Board> entityList = this.boardRepository.findAll();

        List<BoardDto> dtoList = new ArrayList<BoardDto>();

        for (Board entity : entityList) {
            dtoList.add(entity.toDto());
        }

        return dtoList;
    }

    @Override
    public BoardDto findByBoardId(Long boardId) {
        return this.boardRepository.findById(boardId).get().toDto();
    }

    @Override
    @Transactional
    public BoardDto saveBoard(BoardDto dto) {
        return this.boardRepository.save(dto.toEntity()).toDto();
    }

    @Override
    @Transactional
    public Integer updateBoard(Long boardId, BoardDto dto) {
        return this.boardRepository.updateBoard(dto.toEntity(boardId));
    }

    @Override
    @Transactional
    public void deleteBoard(Long boardId) {
        this.boardRepository.deleteById(boardId);
    }
}
