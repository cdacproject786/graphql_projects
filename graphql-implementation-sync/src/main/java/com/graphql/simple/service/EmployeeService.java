package com.graphql.simple.service;

import com.graphql.simple.exception.ResourceNotFoundException;
import com.graphql.simple.request.EmployeeRequest;
import com.graphql.simple.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);
    List<EmployeeResponse> getAllEmployees();

    public EmployeeResponse getEmployeeById(Integer id);
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

    public void deleteEmployee(int id) throws ResourceNotFoundException;

}
