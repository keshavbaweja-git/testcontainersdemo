package com.example.testcontainersdemo.service;

import com.example.testcontainersdemo.model.Department;
import com.example.testcontainersdemo.repository.DepartmentRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceDefault implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Cacheable("departmentCache")
    public List<Department> findAll() {
        return IterableUtils.toList(departmentRepository.findAll());
    }

}
