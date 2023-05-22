package com.graphql.simple.exception;

import com.graphql.simple.response.EmployeeResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceNotFoundException.class)
    public EmployeeResponse resourceNotFoundHandler()
    {
        return new EmployeeResponse();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public EmployeeResponse noElementFoundHandler()
    {
        return new EmployeeResponse();
    }
}
