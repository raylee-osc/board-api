package com.boardapp.boardapi.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.dao.sql.BoardSql;
import com.boardapp.boardapi.board.model.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDaoImpl implements BoardDao {
    @Value("${spring.datasource.driver-class-name}")
    private String DATABASE_DRIVER_CLASS_NAME;

    @Value("${spring.datasource.url}")
    private String DATABASE_URL;

    @Value("${spring.datasource.username}")
    private String DATABASE_USERNAME;

    @Value("${spring.datasource.password}")
    private String DATABASE_PASSWORD;

    @Override
    public List<Board> findAll() {
        List<Board> entityList = new ArrayList<Board>();

        try {
            Class.forName(DATABASE_DRIVER_CLASS_NAME);

            Connection conn =
                    DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(BoardSql.SELECT_ALL);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Board entity = Board.builder()
                                    .boardId(rs.getLong("board_id"))
                                    .boardTitle(rs.getString("board_title"))
                                    .boardContents(rs.getString("board_contents"))
                                    .writeId(rs.getString("write_id"))
                                    .modifyId(rs.getString("modify_id"))
                                    .writeDate(rs.getDate("write_date"))
                                    .modifyDate(rs.getDate("modify_date"))
                                    .build();

                entityList.add(entity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entityList;
    }

    @Override
    public Board findById(Long boardId) {
        Board entity = new Board();

        try {
            Class.forName(DATABASE_DRIVER_CLASS_NAME);

            Connection conn =
                    DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(BoardSql.SELECT_BY_ID);

            pstmt.setLong(1, boardId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                entity = Board.builder()
                                    .boardId(rs.getLong("board_id"))
                                    .boardTitle(rs.getString("board_title"))
                                    .boardContents(rs.getString("board_contents"))
                                    .writeId(rs.getString("write_id"))
                                    .modifyId(rs.getString("modify_id"))
                                    .writeDate(rs.getDate("write_date"))
                                    .modifyDate(rs.getDate("modify_date"))
                                    .build();
            } else {
                log.error("Error occured when find specific post ...");
            }
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public Integer save(Board board) {
        Integer result = 0;
        try {
            Class.forName(DATABASE_DRIVER_CLASS_NAME);

            Connection conn =
                    DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(BoardSql.INSERT_BOARD);

            pstmt.setString(1, board.getBoardTitle());
            pstmt.setString(2, board.getBoardContents());
            pstmt.setString(3, board.getWriteId());
            pstmt.setDate(4, board.getWriteDate());

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Integer update(Board board) {
        Integer result = 0;
        
        try {
            Class.forName(DATABASE_DRIVER_CLASS_NAME);

            Connection conn =
                    DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(BoardSql.UPDATE_BY_ID);

            pstmt.setString(1, board.getBoardTitle());
            pstmt.setString(2, board.getBoardContents());
            pstmt.setString(3, board.getModifyId());
            pstmt.setDate(4, board.getModifyDate());
            pstmt.setLong(5, board.getBoardId());

            result = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Integer delete(Long boardId) {
        Integer result = 0;

        try {
            Class.forName(DATABASE_DRIVER_CLASS_NAME);

            Connection conn =
                    DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(BoardSql.DELETE_BY_ID);

            pstmt.setLong(1, boardId);

            result = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
