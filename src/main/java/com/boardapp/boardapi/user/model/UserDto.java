package com.boardapp.boardapi.user.model;

import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.entity.UserInfo;
import lombok.Getter;

@Getter
public class UserDto {
    private String userId;
    private String userPassword;

    private String userName;
    private String userEmail;
    private String userPhonenumber;

    public User toUserEntity() {
        return User.builder()
                    .userId(this.userId)
                    .userPassword(this.userPassword)
                    .userInfo(UserInfo.builder()
                                        .userName(this.userName)
                                        .userEmail(this.userEmail)
                                        .userPhonenumber(this.userPhonenumber)
                                        .build())
                    .build();
    }

    public UserInfo toUserInfoEntity() {
        return UserInfo.builder()
                        .userName(this.userName)
                        .userEmail(this.userEmail)
                        .userPhonenumber(this.userPhonenumber)
                        .build();
    }
}
