package com.example.users_demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundExceptionHandler(ConfigDataResourceNotFoundException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>("Error:"+message, HttpStatus.NOT_FOUND);
    }
}
