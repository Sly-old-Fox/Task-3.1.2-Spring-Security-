package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.dto.UserMapper;
import ru.itmentor.spring.boot_security.demo.dto.UserResponseDTO;
import ru.itmentor.spring.boot_security.demo.security.UserDetailsWrapper;


@RestController
@RequestMapping("/user/api")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public UserResponseDTO show(@AuthenticationPrincipal UserDetailsWrapper userDetailsWrapper) {
        return userMapper.userToUserResponseDTO(userDetailsWrapper.getUser());
    }
}
