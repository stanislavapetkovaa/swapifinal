package com.swapi.swapi.error;


import lombok.Getter;

@Getter
public class ObjectNotFound extends SWAPIAPIException {

    ObjectNotFound(String entityClass, String entityId) {
        super(ERROR_MESSAGE);
        this.entityClass = entityClass;
        this.entityId = entityId;
    }

    private static final String ERROR_MESSAGE = "Object not found";
    private String entityClass;
    private String entityId;


    
    }

    

