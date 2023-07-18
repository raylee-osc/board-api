package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAllUser() {
        Iterable<User> entityList = this.userRepository.findAll();

        List<UserDto> dtoList = new ArrayList<UserDto>();

        for (User entity : entityList) {
            dtoList.add(entity.toDto());
        }

        return dtoList;
    }

    @Override
    public UserDto findByUserId(String userId) {
        return this.userRepository.findById(userId).get().toDto();
    }

    @Override
    @Transactional
    public Integer saveUser(UserDto dto) {
        return this.userRepository.saveUser(dto.toEntity());
    }

    @Override
    @Transactional
    public Integer updateUser(String userId, UserDto dto) {
        return this.userRepository.updateUser(dto.toEntity(userId));
    }

    @Override
    @Transactional
    public void deleteUser(String userId) {
        this.userRepository.deleteById(userId);
    }
}
