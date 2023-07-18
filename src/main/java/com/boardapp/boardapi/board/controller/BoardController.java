package com.boardapp.boardapi.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public BoardDto saveBoard(@RequestBody BoardDto dto) {
        return this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{boardId}")
    public Integer updateBoard(@PathVariable Long boardId, @RequestBody BoardDto dto) {
        return this.boardService.updateBoard(boardId, dto);
    }

    @DeleteMapping("/:{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        this.boardService.deleteBoard(boardId);
    }
}
