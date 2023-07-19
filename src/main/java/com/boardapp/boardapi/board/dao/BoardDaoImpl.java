package com.boardapp.boardapi.board.dao;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {
    private final SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMESPACE = "BoardDao";

    @Override
    public List<Board> findAllByCustomQuery(Map<String, String> allParams) {
        return this.sqlSessionTemplate.selectList(NAMESPACE + ".findAllByCustomQuery", allParams);
    }

    @Override
    public Board findByCustomQuery(Map<String, String> allParams) {
        return this.sqlSessionTemplate.selectOne(NAMESPACE + ".findByCustomQuery", allParams);
    }

    @Override
    public Integer saveBoard(Board board) {
        return this.sqlSessionTemplate.insert(NAMESPACE + ".saveBoard", board);
    }

    @Override
    public Integer updateBoard(Board board) {
        return this.sqlSessionTemplate.update(NAMESPACE + ".updateBoard", board);
    }

    @Override
    public Integer deleteByCustomQuery(Map<String, String> param) {
        return this.sqlSessionTemplate.delete(NAMESPACE + ".deleteByCustomQuery", param);
    }

}
