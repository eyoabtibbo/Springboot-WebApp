package com.example.SpringbootWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeBusinessService {

    @Autowired
    private EmployeeRepository repository;

    public List <Employee> retrieveEmployeeInDatabase() {
        List<Employee> employees = repository.findAll();
        for(Employee employee:employees) {
            employee.setUsername(employee.getFirstName().concat(employee.getLastName()));
        }
        return employees;
    }


}
