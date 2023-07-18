package com.boardapp.boardapi.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.dao.sql.BoardSql;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDaoImpl implements BoardDao{
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;

    private static final String DATABASE_DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/jdbc?allowPublicKeyRetrieval=true&connectionTimeZone=UTC";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "123456";

    public BoardDaoImpl() {
        try{
            Class.forName(DATABASE_DRIVER_CLASS_NAME);
            this.conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

        } catch(SQLException e) {
        } catch(ClassNotFoundException e){
        }
    }

    @Override
    public List<Board> findAll() {
        List<Board> entityList = new ArrayList<Board>();

        try {
            Class.forName(DATABASE_DRIVER_CLASS_NAME);

            Connection conn = DriverManager.getConnection(DATABASE_USERNAME, DATABASE_URL, DATABASE_PASSWORD);
    
            PreparedStatement ps = conn.prepareStatement(BoardSql.SELECT_ALL);
    
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return entityList;
    }

    @Override
    public Board findById(Long boardId) {
        try {
            Connection conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement(BoardSql.SELECT_BY_ID);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return Board.builder()
                            .boardId(rs.getLong("board_id"))
                            .boardTitle(rs.getString("board_title"))
                            .boardContents(rs.getString("board_contents"))
                            .writeId(rs.getString("write_id"))
                            .modifyId(rs.getString("modify_id"))
                            .writeDate(rs.getDate("write_date"))
                            .modifyDate(rs.getDate("modify_date"))
                            .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Board board) {
        try {
            Connection conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement(BoardSql.INSERT_BOARD);

            ps.setString(1, board.getBoardTitle());
            ps.setString(2, board.getBoardContents());
            ps.setString(3, board.getWriteId());
            ps.setDate(4, board.getWriteDate());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Board board) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(BoardSql.UPDATE_BY_ID);

            ps.setString(1, board.getBoardTitle());
            ps.setString(2, board.getBoardContents());
            ps.setString(3, board.getModifyId());
            ps.setDate(4, board.getModifyDate());
            ps.setLong(5, board.getBoardId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long boardId) {
        try {
            Connection conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement(BoardSql.DELETE_BY_ID);

            ps.setLong(1, boardId);

            int out = ps.executeUpdate();

            if (out != 0) {
                log.info("Board deleted with id = " + boardId);
            } else {
                log.error("No Board found with id = " + boardId);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
