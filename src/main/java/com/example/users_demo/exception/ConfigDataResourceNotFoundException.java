package com.example.users_demo.exception;

import lombok.Data;

@Data
public class ConfigDataResourceNotFoundException extends RuntimeException{

    Long id;


    public ConfigDataResourceNotFoundException(Long id) {
        super("Resource with "+id+ "not found ");
    }
}
