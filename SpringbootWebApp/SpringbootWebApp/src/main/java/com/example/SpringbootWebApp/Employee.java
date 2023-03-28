package com.example.SpringbootWebApp;

public class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private String address;



    public Employee() {

    }
    public Employee(String firstName,String lastName, int id, String address ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
