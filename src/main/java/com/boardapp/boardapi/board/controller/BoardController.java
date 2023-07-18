package com.boardapp.boardapi.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<BoardDto> findAllBoards() {
        return this.boardService.findAllBoards();
    }

    @GetMapping("/:{boardId}")
    public BoardDto findByBoardId(@PathVariable Long boardId) {
        return this.boardService.findByBoardId(boardId);
    }
}
