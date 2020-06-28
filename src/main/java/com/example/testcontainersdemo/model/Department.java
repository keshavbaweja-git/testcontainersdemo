package com.example.testcontainersdemo.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Department implements Serializable {
    @Id
    private final Long id;
    private final String name;

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Department of(String name) {
        return new Department(null, name);
    }

    public Department with(Long id) {
        return new Department(id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
