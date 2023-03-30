package com.example.SpringbootWebApp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

   public static Employee[] employees =  {
            new Employee("Bobby", "Wills",100011, "3742 White Oak Drive, Weston, Missouri"),
            new Employee("Rob", "Moore", 200022, "44597 A Avenue, Edmonton, Alberta"),
            new Employee("Mack","Mckinney", 200023, " 2659 boulevard des Laurentides, La Tuque, Quebec"),
            new Employee("Jay", "York",400045, " 754 Birkett Lane, Brantford, Ontario"),
            new Employee("Smith","Jennings", 500053, "1033 Weir Crescent, Toronto, Ontario"),
            new Employee("Greg", "Larson",100083, "825 rue Saint-Charles, Longueuil, Quebec"),
    };


public Employee getEmployeeId (int id) {
    for(int i=0; i<employees.length ;i++) {
        if (employees[i].getId()==id) {
            return employees[i];
        }
    }
    return null;
};
    public Employee getEmployeeByFirstName (String name) {
        for(int i=0; i<employees.length ;i++) {
            if ((employees[i].getFirstName()).equals(name)) {
                return employees[i];
            }
        }
        return null;
    };
    public Employee getEmployeeByLastName (String name) {
        for(int i=0; i<employees.length ;i++) {
            if ((employees[i].getLastName()).equals(name)) {
                return employees[i];
            }
        }
        return null;
    };
    @GetMapping("/listEmployees")
    public Employee[] listEmployees() {
        return employees;

    }
    @GetMapping("/listEmployees/{id}")
    public Employee listEmployeesId(@PathVariable int id) {
        return getEmployeeId(id);
    }
    @GetMapping("/listEmployees/firstName={firstName}")
    public Employee listEmployeesFirstName(@PathVariable String firstName) {
        return getEmployeeByFirstName(firstName);
    }

    @GetMapping("/listEmployees/lastName={lastName}")
    public Employee listEmployeesLastName(@PathVariable String lastName) {
        return getEmployeeByLastName(lastName);
    }
    @GetMapping("/listEmployees/address")
    public Employee listEmployeesAddress(@PathVariable String address) {
        Employee employee= employees[Integer.parseInt(address)];
        return employee;
    }

}
