package com.example.testcontainersdemo.repository;

import com.example.testcontainersdemo.TestcontainersdemoApplication;
import com.example.testcontainersdemo.model.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.google.common.collect.ImmutableList;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = {TestcontainersdemoApplication.class})
@Testcontainers
@Sql({"/test-schema.sql"})
@Transactional
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void findAll(){
        Iterable<Department> departmentIterable = departmentRepository.findAll();
        List<Department> departments = ImmutableList.copyOf(departmentIterable);
        assertThat(departments.size(), is(4));
    }
}
