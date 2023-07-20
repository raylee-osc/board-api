package com.boardapp.boardapi.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public Iterable<Board> findAllBoard() {
        return this.boardService.findAll();
    }

    @GetMapping("/:{boardId}")
    public Board findByBoardId(@PathVariable Long boardId) {
        return this.boardService.findById(boardId);
    }

    @PostMapping
    public Board saveBoard(@RequestBody Board dto) {
        return this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{boardId}")
    public Integer updateBoard(@PathVariable Long boardId, @RequestBody Board dto) {
        return this.boardService.updateBoard(boardId, dto);
    }

    @DeleteMapping("/:{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        this.boardService.deleteBoard(boardId);
    }
}
