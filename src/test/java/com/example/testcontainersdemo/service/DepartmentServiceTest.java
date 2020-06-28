package com.example.testcontainersdemo.service;
import com.example.testcontainersdemo.TestcontainersdemoApplication;
import com.example.testcontainersdemo.model.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = {TestcontainersdemoApplication.class})
@Testcontainers
@Sql({"/test-schema.sql"})
@Transactional
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void findAll(){
        List<Department> departments = departmentService.findAll();
        assertThat(departments.size(), is(3));
        departments = departmentService.findAll();
        assertThat(departments.size(), is(3));
    }

}
