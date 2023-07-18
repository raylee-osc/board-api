package com.boardapp.boardapi.user.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> findAllUser() {
        return this.userService.findAllUser();
    }

    @GetMapping("/:{userId}")
    public UserDto findByUserId(@PathVariable String userId) {
        return this.userService.findByUserId(userId);
    }

    @PostMapping
    public String saveUser(@RequestBody UserDto dto) {
        return "Effected Row : " + this.userService.saveUser(dto);
    }

    @PutMapping("/:{userId}")
    public String updateUser(@PathVariable String userId, @RequestBody UserDto dto) {
        return "Effected Row : " + this.userService.updateUser(userId, dto);
    }

    @DeleteMapping("/:{userId}")
    public String deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);

        return "OK";
    }
}
