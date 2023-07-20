package com.boardapp.boardapi.board.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.board.model.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
    @Modifying
    @Query("UPDATE board SET board_title = :boardTitle, board_contents = :boardContents, modify_id = :modifyId WHERE board_id = :boardId")
    Integer update(@Param("boardTitl") String title, @Param("boardContents") String contents, @Param("modifyId") String modifyId, @Param("boardId") Long od);
}
