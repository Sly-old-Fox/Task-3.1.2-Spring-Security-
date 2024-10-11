package ru.itmentor.spring.boot_security.demo.controller;

import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.dto.UserDTO;
import ru.itmentor.spring.boot_security.demo.dto.UserMapper;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/admin/api/users")
public class AdminController {

    private final UserMapper userMapper;
    private final UserService userService;


    @Autowired
    public AdminController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return userMapper.userToUserDTO(userService.getUserById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Validated({Default.class}) @RequestBody UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userService.saveUser(user);
        return user;
    }

    @PatchMapping("/{id}")
    public User update(@Validated({Default.class}) @RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        User user = userMapper.userDTOToUser(userDTO);
        userService.updateUser(user, id);
        return user;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
