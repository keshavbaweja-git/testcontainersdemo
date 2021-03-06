package com.example.testcontainersdemo.service;

import com.example.testcontainersdemo.model.Department;
import com.example.testcontainersdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DepartmentServiceDefault implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Cacheable("departmentCache")
    public Map<String, Department> findAll() {
        final Map<String, Department> m = new HashMap<>();
        departmentRepository.findAll().forEach(d -> m.put(d.getName(), d));
        return m;
    }

}
