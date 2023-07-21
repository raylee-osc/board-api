package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Iterable<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/:{userId}")
    public User findByUserId(@PathVariable String userId) {
        return this.userService.findByUserId(userId);
    }

    @PostMapping
    public String saveUser(@RequestBody UserDto dto) {
        return "Effected Row : " + this.userService.save(dto);
    }

    @DeleteMapping("/:{userId}")
    public void deleteUser(@PathVariable String userId) {
        this.userService.delete(userId);
    }
}
