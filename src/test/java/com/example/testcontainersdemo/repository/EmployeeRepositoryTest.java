package com.example.testcontainersdemo.repository;

import com.example.testcontainersdemo.TestcontainersdemoApplication;
import com.example.testcontainersdemo.model.Department;
import com.example.testcontainersdemo.model.Employee;
import com.example.testcontainersdemo.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = {TestcontainersdemoApplication.class})
@Testcontainers
@Sql({"/test-schema.sql"})
@Transactional
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void save() {
        Map<String, Department> departments = departmentService.findAll();
        Employee employee = Employee.of("Keshav", "Baweja", departments.get("board").getId());
        Employee persistedEmployee = employeeRepository.save(employee);
        assertThat(persistedEmployee.getFirstName(), is("Keshav"));
    }

    @Test
    public void find() {
        Map<String, Department> departments = departmentService.findAll();
        Employee employee = Employee.of("Keshav", "Baweja", departments.get("board").getId());
        Employee persistedEmployee = employeeRepository.save(employee);
        assertThat(persistedEmployee.getFirstName(), is("Keshav"));
        Employee foundEmployee = employeeRepository.findById(persistedEmployee.getId()).get();
        assertThat(foundEmployee.getLastName(), is("Baweja"));
    }

}
