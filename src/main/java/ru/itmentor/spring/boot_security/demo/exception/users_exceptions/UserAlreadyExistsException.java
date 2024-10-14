package ru.itmentor.spring.boot_security.demo.exception.users_exceptions;

public class UserAlreadyExistsException extends UserCustomException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException() {
        super("username already exists");
    }
}
