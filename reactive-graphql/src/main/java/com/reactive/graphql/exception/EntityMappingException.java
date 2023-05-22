package com.reactive.graphql.exception;

public class EntityMappingException extends RuntimeException {

    public EntityMappingException(String message) {
        super(message);
    }

    public EntityMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
