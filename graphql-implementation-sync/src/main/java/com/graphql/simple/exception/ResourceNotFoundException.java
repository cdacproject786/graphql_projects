package com.graphql.simple.exception;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
