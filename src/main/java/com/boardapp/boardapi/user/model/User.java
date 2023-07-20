package com.boardapp.boardapi.user.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import com.boardapp.boardapi.board.model.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("user")
public class User implements Persistable<String>{
    @Column("index_id")
    private Long indexId;

    @Id
    @Column("user_id")
    @Setter
    private String userId;

    @Column("user_name")
    private String userName;

    @Column("user_email")
    private String userEmail;

    @Column("user_password")
    private String userPassword;

    @Setter
    @MappedCollection(idColumn = "write_id", keyColumn = "board_id")
    List<Board> writeBoardList = new ArrayList<Board>();

    @Setter
    @MappedCollection(idColumn = "modify_id", keyColumn = "board_id")
    List<Board> modifyBoardList = new ArrayList<Board>();

    @Setter
    @Transient
    private boolean isNew = false;

    @Override
    @Nullable
    public String getId() {
        return this.userId;
    }

    public void addWriteBoard(Board board) {
        this.writeBoardList.add(board);
    }

    public void addModifyBoard(Board board) {
        this.modifyBoardList.add(board);
    }
}