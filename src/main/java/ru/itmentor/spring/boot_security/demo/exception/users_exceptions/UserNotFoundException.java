package ru.itmentor.spring.boot_security.demo.exception.users_exceptions;

public class UserNotFoundException extends UserCustomException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("user not found");
    }
    public UserNotFoundException(Long id) {
        super("user "+id+" not found");
    }
}
