package com.boardapp.boardapi.user.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Iterable<User> findAllUser() {
        return this.userRepository.findAll();
    }

    public User findByUserId(String userId) {
        return this.userRepository.findById(userId).get();
    }

    public User saveUser(User dto) {
        dto.setNew(true);

        return this.userRepository.save(dto);
    }

    public User updatUser(String userId, User dto) {
        dto.setUserId(userId);
        
        return this.userRepository.save(dto);
    }

    public void deleteUser(String userId){
        this.userRepository.deleteById(userId);
    }
}
