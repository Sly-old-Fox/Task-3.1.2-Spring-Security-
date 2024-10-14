package ru.itmentor.spring.boot_security.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itmentor.spring.boot_security.demo.exception.users_exceptions.UserAlreadyExistsException;
import ru.itmentor.spring.boot_security.demo.exception.users_exceptions.UserNotFoundException;
import ru.itmentor.spring.boot_security.demo.util.UserErrorResponse;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e){
        UserErrorResponse userErrorResponse=new UserErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BindException.class)
    private ResponseEntity<UserErrorResponse> handleException(BindException e){
        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> String.format("Field: '%s' - Error: '%s'", error.getField(), error.getDefaultMessage()))
                .toList();
          UserErrorResponse userErrorResponse=new UserErrorResponse(errors.toString(), LocalDateTime.now());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<UserErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException e) {
        UserErrorResponse userErrorResponse=new UserErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.CONFLICT);
    }
}

