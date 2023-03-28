package com.example.SpringbootWebApp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    Employee[] employees =  {
            new Employee("Bob", 1001),
            new Employee("Rob", 2002),
            new Employee("Mack", 2003),
            new Employee("Jay", 4004),
            new Employee("Smith", 5005),
            new Employee("Harry", 6006),
            new Employee("Will", 7007),
            new Employee("Greg", 1008),
            new Employee("Ian", 1009),
            new Employee("Connor", 1010),

    };


    @GetMapping("/listEmployees")
    public Employee[] listEmployees() {
        return employees;

    }
    @GetMapping("/listEmployees/{id}")
    public Employee listEmployeesId(@PathVariable int id) {
        Employee employee= employees[id];
        return employee;

    }
    @PostMapping("/listEmployees/name")
    public String listEmployeesName() {
        return null;

    }

}
