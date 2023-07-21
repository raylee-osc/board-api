package com.boardapp.boardapi.user.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.repository.UserInfoRepository;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findByUserId(String userId) {
        return this.userRepository.findById(userId).get();
    }

    public Integer save(UserDto dto) {
        Integer effectedRow = this.userRepository.save(dto.toUserEntity()) == null ? 1 : 0;
        effectedRow = this.userInfoRepository.save(dto.toUserInfoEntity()) == null ? 2 : 1;

        return effectedRow;
    }

    public Integer update(UserDto dto) {
        return 1;
    } 

    public void delete(String userId) {
        this.userRepository.deleteById(userId);
    }
}
