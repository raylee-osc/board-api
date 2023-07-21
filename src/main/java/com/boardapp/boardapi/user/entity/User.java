package com.boardapp.boardapi.user.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table("user")
public class User implements Persistable<String>{
    @Column("user_id")
    private String userId;

    @Column("user_password")
    private String userPassword;

    @Column("index_id")
    private UserInfo userInfo;

    @Setter
    @Transient
    @JsonIgnore
    public boolean isNew = false;

    @Override
    @Nullable
    @JsonIgnore
    public String getId() {
        return this.userId;
    }

    @Builder
    public User(String userId, String userPassword, UserInfo userInfo) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userInfo = userInfo;
    }
}
