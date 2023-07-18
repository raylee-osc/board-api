package com.boardapp.boardapi.user.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long index;

    private String id;
    private String name;
    private String password;
    private String phonenumber;

    private Date createdDate;
    private Date modifiedDate; 

    public User toEntity() {
        return User.builder()
                    .userId(this.id)
                    .userName(this.name)
                    .userPassword(this.password)
                    .userPhonenumber(this.phonenumber)
                    .createdDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }

    public User toEntity(String userId) {
        return User.builder()
                    .userId(userId)
                    .userName(this.name)
                    .userPassword(this.password)
                    .userPhonenumber(this.phonenumber)
                    .modifiedDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }
}
