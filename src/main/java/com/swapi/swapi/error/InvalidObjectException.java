package com.swapi.swapi.error;

import java.util.Map;

import lombok.Getter;

@Getter
public class InvalidObjectException extends SWAPIAPIException {
    private final Map<String, String> constraintViolations;

    public InvalidObjectException(String message, Map<String, String> constraintViolations) {
        super(message);
        this.constraintViolations = constraintViolations;
    }

    
}
