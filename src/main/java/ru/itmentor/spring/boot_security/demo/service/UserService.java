package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.itmentor.spring.boot_security.demo.dto.UserDTO;
import ru.itmentor.spring.boot_security.demo.dto.UserResponseDTO;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void updateUser(User user, Long id);

    void deleteUser(Long id);

    void saveUserDTO(UserDTO user);

    UserDTO getUserDTOById(Long id);

    void updateUserDTO(UserDTO user, Long id);

    UserResponseDTO showUser(User user);
}
