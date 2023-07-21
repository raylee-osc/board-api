package com.boardapp.boardapi.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Table("user_info")
public class UserInfo {
    @Id
    @Column("index_id")
    private Long index_id;

    @Column("user_name")
    private String userName;

    @Column("user_email")
    private String userEmail;

    @Column("user_phonenumber")
    private String userPhonenumber;
}
