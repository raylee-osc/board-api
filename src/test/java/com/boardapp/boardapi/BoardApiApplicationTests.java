package com.boardapp.boardapi;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
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
	void findAll() {
		List<Board> entityList = this.boardDao.findAllByCustomQuery(null);
	}

	@Test
	void findById() {
		Board entity = this.boardDao.findByCustomQuery(null);
	}

	@Test
	void save() {
		Board params = Board.builder()
							.boardTitle("1번 게시글 제목")
							.boardContents("1번 게시글 내용")
							.writeId("User1")
							.writeDate(LocalDateTime.now())
							.build();

		this.boardDao.saveBoard(params);

		Map<String, String> mapParams = new HashMap<>();

		mapParams.put("writeId","User1");

		Board entity = this.boardDao.findByCustomQuery(mapParams);
		
		assertThat(entity.getBoardTitle()).isEqualTo("1번 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("1번 게시글 내용");
		assertThat(entity.getWriteId()).isEqualTo("User1");
	}

	@Test
	void update() {
		Board params = Board.builder()
							.boardId(Long.valueOf(2))
							.boardTitle("2번 게시글 제목")
							.boardContents("2번 게시글 내용")
							.modifyId("User2")
							.modifyDate(LocalDateTime.now())
							.build();

		this.boardDao.updateBoard(params);

		Map<String, String> mapParams = new HashMap<>();

		mapParams.put("modifyId","User2");

		Board entity = this.boardDao.findByCustomQuery(mapParams);

		assertThat(entity.getBoardTitle()).isEqualTo("2번 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("2번 게시글 내용");
		assertThat(entity.getModifyId()).isEqualTo("User2");
	}

	@Test
	void delete() {
		Map<String, String> param = new HashMap<>();

		param.put("boardId", "1");

		this.boardDao.deleteByCustomQuery(param);
	}
}
