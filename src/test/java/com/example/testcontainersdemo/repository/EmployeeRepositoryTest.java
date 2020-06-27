package com.example.testcontainersdemo.repository;

import com.example.testcontainersdemo.TestcontainersdemoApplication;
import com.example.testcontainersdemo.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@SpringBootTest(classes = {TestcontainersdemoApplication.class})
@Testcontainers
@Sql({"/test-schema.sql"})
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void save(){
        Employee employee = Employee.of("Keshav", "Baweja");
        Employee persistedEmployee = employeeRepository.save(employee);
        assertThat(persistedEmployee.getFirstName(), is("Keshav"));
    }

}
