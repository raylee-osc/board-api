package com.boardapp.boardapi;

import static org.assertj.core.api.Assertions.assertThat;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.boardapp.boardapi.board.dao.BoardDao;
import com.boardapp.boardapi.board.model.Board;

@SpringBootTest
class BoardApiApplicationTests {

	@Autowired
	BoardDao boardDao;

	@Test
	void findAllTest() {
		List<Board> entityList = this.boardDao.findAll();
	}

	@Test
	void findByIdTest() {
		Board entity = this.boardDao.findById(Long.valueOf(1));
	}

	@Test
	void saveTest() {
		Board board = Board.builder()
							.boardTitle("새로운 게시글 제목")
							.boardContents("새로운 게시글 내용")
							.writeId("작성자1")
							.writeDate(new Date(System.currentTimeMillis()))
							.build();

		this.boardDao.save(board);

		Board entity = this.boardDao.findById(Long.valueOf(1));

		assertThat(entity.getBoardTitle()).isEqualTo("새로운 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("새로운 게시글 내용");
		assertThat(entity.getWriteId()).isEqualTo("작성자1");
	}

	@Test
	void updateTest() {
		Board board = Board.builder()
							.boardId(Long.valueOf(1))
							.boardTitle("수정된 게시글 제목")
							.boardContents("수정된 게시글 내용")
							.modifyId("수정자1")
							.modifyDate(new Date(System.currentTimeMillis()))
							.build();

		this.boardDao.update(board);

		Board entity = this.boardDao.findById(Long.valueOf(1));

		assertThat(entity.getBoardTitle()).isEqualTo("수정된 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("수정된 게시글 내용");
		assertThat(entity.getModifyId()).isEqualTo("수정자1");
	}

	@Test
	void deleteTest() {
		this.boardDao.delete(Long.valueOf(11));
	}
}
