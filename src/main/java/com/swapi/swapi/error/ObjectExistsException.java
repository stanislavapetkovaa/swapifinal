package com.swapi.swapi.error;

public class ObjectExistsException extends SWAPIAPIException {
    public ObjectExistsException() {
        super(ERROR_MESSAGE);
        this.entityClass = entityClass;
        this.entityId = entityId;
    }

    private static final String ERROR_MESSAGE = "Object exists";
    private String entityClass;
    private String entityId;


}
