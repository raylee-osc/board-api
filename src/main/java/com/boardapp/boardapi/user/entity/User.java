package com.boardapp.boardapi.user.entity;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.user.model.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Column("index_id")
    private Long indexId;

    @Id
    @Column("user_id")
    private String userId;

    @Column("user_name")
    private String userName;

    @Column("user_password")
    private String userPassword;
    
    @Column("user_phonenumber")
    private String userPhonenumber;

    @Column("created_date")
    private Date createdDate;

    @Column("modified_date")
    private Date modifiedDate;

    @Transient
    @Setter
    @MappedCollection(idColumn = "write_id", keyColumn = "board_id")
    private List<Board> writeBoards = new ArrayList<Board>();

    @Transient
    @Setter
    @MappedCollection(idColumn = "modify_id", keyColumn = "board_id")
    private List<Board> modifyBoards = new ArrayList<Board>();

    public void addWriteBoard(Board board) {
        this.writeBoards.add(board);
    }

    public void addModifyBoard(Board board) {
        this.modifyBoards.add(board);
    }

    public UserDto toDto() {
        return UserDto.builder()
                        .index(this.indexId)
                        .id(this.userId)
                        .name(this.userName)
                        .password(this.userPassword)
                        .phonenumber(this.userPhonenumber)
                        .createdDate(this.createdDate)
                        .modifiedDate(this.modifiedDate)
                        .build();
    }

    @Builder
    public User(
        Long indexId,
        String userId,
        String userName,
        String userPassword,
        String userPhonenumber,
        Date createdDate,
        Date modifiedDate
    ){
        this.indexId = indexId;

        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhonenumber = userPhonenumber;

        this.createdDate = createdDate;
        this.modifiedDate =modifiedDate;
    }
}
