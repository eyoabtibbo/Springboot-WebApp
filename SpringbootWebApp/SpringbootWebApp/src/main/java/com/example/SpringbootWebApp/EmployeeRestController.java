package com.example.SpringbootWebApp;


import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {


   public static Employee[] employees;

    static {
        try {
            employees = readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Employee[] readFile () throws IOException, ParseException {
       JSONParser parser = new JSONParser();
       JSONArray reader = (JSONArray) parser.parse(new FileReader("Data.json"));
       ArrayList<Employee> allEmployees = new ArrayList<>();
       Employee[] employeeArray = new Employee[((int)reader.stream().count())];
       for (Object o : reader) {
           JSONObject employee = (JSONObject) o;

           String firstName = (String) employee.get("firstName");
           String lastName = (String) employee.get("lastName");
           long idl = (long) employee.get("id");
           int id = (int)idl;
           String address = (String) employee.get("address");

           allEmployees.add(new Employee(firstName, lastName, id, address));

       }
       allEmployees.toArray(employeeArray);
       return employeeArray;
   }


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

    public Employee getEmployeeByAddress (String address) {
        for(int i=0; i < employees.length; i++) {
            if ((employees[i].getAddress()).equals(address)) {
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
    public Employee listEmployeesId(@PathVariable int id, HttpServletResponse response) {
        Employee retrievedEmployee = getEmployeeId(id);
        if(retrievedEmployee == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return retrievedEmployee;
    }
    @GetMapping("/listEmployees/firstname={firstName}")
    public Employee listEmployeesFirstName(@PathVariable String firstName, HttpServletResponse response) {
        Employee retrievedEmployee = getEmployeeByFirstName(firstName);
        if(retrievedEmployee == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return retrievedEmployee;
    }

    @GetMapping("/listEmployees/lastname={lastName}")
    public Employee listEmployeesLastName(@PathVariable String lastName, HttpServletResponse response) {
        Employee retrievedEmployee = getEmployeeByLastName(lastName);
        if(retrievedEmployee == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return retrievedEmployee;
    }
    @GetMapping("/listEmployees/address")
    public Employee listEmployeesAddress(@PathVariable String address, HttpServletResponse response) {
        Employee retrievedEmployee = getEmployeeByAddress(address);
        if(retrievedEmployee == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return retrievedEmployee;
    }

}
