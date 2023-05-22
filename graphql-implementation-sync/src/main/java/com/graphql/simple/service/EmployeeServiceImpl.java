package com.graphql.simple.service;

import com.graphql.simple.entity.Employee;
import com.graphql.simple.exception.ResourceNotFoundException;
import com.graphql.simple.repository.EmployeeRepository;
import com.graphql.simple.request.EmployeeRequest;
import com.graphql.simple.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest)
    {
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        Employee savedEmployee = this.employeeRepository.save(employee);
        return this.modelMapper.map(savedEmployee,EmployeeResponse.class);
    }


    public List<EmployeeResponse> getAllEmployees()
    {
        List<Employee> allEmployees = this.employeeRepository.findAll();
        List<EmployeeResponse> employeeResponses = new ArrayList<>(allEmployees.size());

        for(Employee employee: allEmployees)
            employeeResponses.add(modelMapper.map(employee,EmployeeResponse.class));

        return employeeResponses;
    }

    public EmployeeResponse getEmployeeById(Integer id)
    {
        Employee employee = this.employeeRepository.findById(id).get();
        EmployeeResponse response = this.modelMapper.map(employee,EmployeeResponse.class);
        if(response == null)
            throw new NoSuchElementException("Resource not found");
        return response;
    }


    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest)
    {
        Employee foundEmployee = this.employeeRepository.findById(employeeRequest.getEmpId()).get();
        if(foundEmployee == null)
            throw new ResourceNotFoundException("The data is not present by this id");
        else
        {
            foundEmployee.setAge(employeeRequest.getAge());
            foundEmployee.setName(employeeRequest.getName());
            foundEmployee.setPhone(employeeRequest.getPhone());
            foundEmployee.setNationality(employeeRequest.getNationality());
            Employee updatedEmployee = this.employeeRepository.save(foundEmployee);
            return this.modelMapper.map(updatedEmployee,EmployeeResponse.class);
        }
    }


    public void deleteEmployee(int id) throws ResourceNotFoundException
    {
        this.employeeRepository.deleteById(id);
    }
}
