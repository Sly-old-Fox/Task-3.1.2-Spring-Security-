package ru.itmentor.spring.boot_security.demo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(convertRoles(user.getRoles()))")
    UserResponseDTO userToUserResponseDTO(User user);

    @Mapping(target = "roles", expression = "java(convertRoles(userResponseDTO.getRoles()))")
    User userResponseDTOToUser(UserResponseDTO userResponseDTO);

    @Mapping(target = "roles", expression = "java(convertRoles(user.getRoles()))")
    UserDTO userToUserDTO(User user);

    @Mapping(target = "roles", expression = "java(convertRoles(userDTO.getRoles()))")
    User userDTOToUser(UserDTO userDTO);

    default String[] convertRoles(Set<Role> roles) {
        if (!roles.isEmpty()) {
            return roles.stream()
                    .map(Role::getRoleName)
                    .toArray(String[]::new);
        }
        return new String[0];
    }

    default Set<Role> convertRoles(String[] value) {
        Set<Role> roles = new HashSet<>();
        if (value != null) {
            for (String roleName : value) {
                roles.add(new Role(roleName));
            }
        }
        return roles;
    }

    default Role map(String value) {
        return new Role(value);
    }

    default String map(Role value) {
        return value.getRoleName();
    }
}
