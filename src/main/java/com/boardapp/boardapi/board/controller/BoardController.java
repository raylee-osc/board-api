package com.boardapp.boardapi.board.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping(headers = "searchOption=findAll")
    private List<Board> findAllBoards(
            @RequestParam(required = false) Map<String, String> allParams) {
        return this.boardService.findAllByCustomQuery(allParams);
    }

    @GetMapping(headers = "searchOption=findOne")
    private Board findByCustomQuery(@RequestParam(required = false) Map<String, String> allParams) {
        return this.boardService.findByCustomQuery(allParams);
    }

    @PostMapping
    private String saveBoard(@RequestBody Board dto) {
        return "Effected Row : " + this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{boardId}")
    private String updateBoard(@PathVariable Long boardId, @RequestBody Board dto) {
        return "Effected Row : " + this.boardService.updateBoard(boardId, dto);
    }

    @DeleteMapping
    private String deleteBoard(@RequestParam Map<String, String> param) {
        return "Effected Row : " + this.boardService.deleteBoard(param);
    }
}
