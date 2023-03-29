package com.example.SpringbootWebApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeBusinessService businessService;

   public static Employee[] employees =  {
            new Employee("Bobby", "Wills",100011, "3742 White Oak Drive, Weston, Missouri"),
            new Employee("Rob", "Moore", 200022, "44597 A Avenue, Edmonton, Alberta"),
            new Employee("Mack","Mckinney", 200023, " 2659 boulevard des Laurentides, La Tuque, Quebec"),
            new Employee("Jay", "York",400045, " 754 Birkett Lane, Brantford, Ontario"),
            new Employee("Smith","Jennings", 500053, "1033 Weir Crescent, Toronto, Ontario"),
            new Employee("Greg", "Larson",100083, "825 rue Saint-Charles, Longueuil, Quebec"),
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
    @GetMapping("/listEmployees/firstName")
    public Employee listEmployeesFirstName(@PathVariable String firstName) {
        Employee employee= employees[Integer.parseInt(firstName)];
        return employee;
    }
    @GetMapping("/listEmployees/lastName")
    public Employee listEmployeesLastName(@PathVariable String lastName) {
        Employee employee= employees[Integer.parseInt(lastName)];
        return employee;
    }
    @GetMapping("/listEmployees/address")
    public Employee listEmployeesAddress(@PathVariable String address) {
        Employee employee= employees[Integer.parseInt(address)];
        return employee;
    }

    @GetMapping("/employee-in-database")
    public List<Employee> retrieveEmployee() {
        return businessService.addUsernameForAllEmployees();
    }

}
