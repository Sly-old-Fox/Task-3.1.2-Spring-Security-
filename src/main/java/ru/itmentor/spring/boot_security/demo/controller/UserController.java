package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.dto.UserResponseDTO;
import ru.itmentor.spring.boot_security.demo.security.UserDetailsWrapper;
import ru.itmentor.spring.boot_security.demo.service.UserService;


@RestController
@RequestMapping("/user/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserResponseDTO> show(@AuthenticationPrincipal UserDetailsWrapper userDetailsWrapper) {
        return new ResponseEntity<>(userService.showUser(userDetailsWrapper.getUser()), HttpStatus.OK);
    }
}
