package com.boardapp.boardapi.board.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.board.model.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, BoardCustomRepository{
    
}