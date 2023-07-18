package com.boardapp.boardapi.user.service;

import java.util.List;
import com.boardapp.boardapi.user.model.UserDto;

public interface UserService {
    List<UserDto> findAllUser();

    UserDto findByUserId(String userId);

    Integer saveUser(UserDto dto);

    Integer updateUser(String userId, UserDto dto);

    void deleteUser(String userId);
}
