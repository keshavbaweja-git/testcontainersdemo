package com.example.testcontainersdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJdbcRepositories("com.example.testcontainersdemo.repository")
@EnableCaching
public class TestcontainersdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestcontainersdemoApplication.class, args);
    }

    @Value("${embedded.redis.host}")
    private String redisHost;

    @Value("${embedded.redis.port}")
    private String redisPort;

}
