package com.example.testcontainersdemo;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.util.HashMap;
import java.util.Map;

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

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + redisHost + ":" + redisPort);
        return Redisson.create(config);
    }

    @Bean
    CacheManager cacheManager(RedissonClient redissonClient) {
        Map<String, CacheConfig> config = new HashMap<>();
        config.put("departmentCache", new CacheConfig(24 * 60 * 1000, 12 * 60 * 1000));
        return new RedissonSpringCacheManager(redissonClient, config);
    }

}
