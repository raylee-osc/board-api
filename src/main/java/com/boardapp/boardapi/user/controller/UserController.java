package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Iterable<User> findAllUser() {
        return this.userService.findAllUser();
    }

    @GetMapping("/:{userId}")
    public User findByUserId(@PathVariable String userId) {
        return this.userService.findByUserId(userId);
    }

    @PostMapping
    public User saveUser(@RequestBody User dto) {
        return this.userService.saveUser(dto);
    }

    @PutMapping("/:{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User dto) {
        return this.userService.updatUser(userId, dto);
    }

    @DeleteMapping("/:{userId}")
    public void deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);
    }
}
