package com.example.testcontainersdemo.model;

import org.springframework.data.annotation.Id;

public class Employee {
    private final @Id Long id;
    private final String firstName;
    private final String lastName;

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Employee of(String firstName, String lastName){
        return new Employee(null, firstName, lastName);
    }

    public Employee withId(Long id){
        return new Employee(id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id != null ? id.equals(employee.id) : employee.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
