package com.example.testcontainersdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJdbcRepositories("com.example.testcontainersdemo.repository")
public class TestcontainersdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestcontainersdemoApplication.class, args);
	}

}
