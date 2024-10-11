package ru.itmentor.spring.boot_security.demo.exception.users_exceptions;

public class UserCustomException extends RuntimeException {

    private String message;

    public UserCustomException() {
        super();
    }

    public UserCustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
