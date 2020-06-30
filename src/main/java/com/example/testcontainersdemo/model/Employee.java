package com.example.testcontainersdemo.model;

import org.springframework.data.annotation.Id;

public class Employee {
    @Id
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Long deptId;

    public Employee(Long id, String firstName, String lastName, Long deptId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptId = deptId;
    }

    public static Employee of(String firstName, String lastName, Long deptId) {
        return new Employee(null, firstName, lastName, deptId);
    }

    public Employee withId(Long id) {
        return new Employee(id, firstName, lastName, deptId);
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

    public Long getDeptId() {
        return deptId;
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
