package com.swapi.swapi.error;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SWAPIAPIException extends RuntimeException {
     private UUID id;

    SWAPIAPIException(String message) {
        super(message);
        this.id = UUID.randomUUID();
    }

    
}
