package com.graphql.simple.controller;

;
import com.graphql.simple.request.EmployeeRequest;
import com.graphql.simple.response.EmployeeResponse;
import com.graphql.simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @QueryMapping("geAllEmployees")
    List<EmployeeResponse> getAllEmployees()
    {
        return this.employeeService.getAllEmployees();
    }

    @QueryMapping("getEmployeeById")
    public EmployeeResponse findEmployeeById(@Argument int id)
    {
       return this.employeeService.getEmployeeById(id);
    }


    @MutationMapping("addEmployee")
    public EmployeeResponse addEmployee(@Argument EmployeeRequest employeeRequest)
    {
        return this.employeeService.saveEmployee(employeeRequest);
    }

    @MutationMapping("updateEmployee")
    public EmployeeResponse updateEmployee(@Argument EmployeeRequest employeeRequest)
    {
        return this.employeeService.updateEmployee(employeeRequest);
    }

    @MutationMapping("deleteEmployeeById")
    public void deleteEmployee(@Argument int id)
    {
        this.employeeService.deleteEmployee(id);
    }
}
