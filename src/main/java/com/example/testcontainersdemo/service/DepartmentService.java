package com.example.testcontainersdemo.service;

import com.example.testcontainersdemo.model.Department;

import java.util.Map;

public interface DepartmentService {
    Map<String, Department> findAll();
}
