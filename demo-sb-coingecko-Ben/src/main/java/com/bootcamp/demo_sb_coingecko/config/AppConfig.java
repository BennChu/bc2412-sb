package com.bootcamp.demo_sb_coingecko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_coingecko.codewave.RedisManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
    
    // RestTemplate 係 spring boot 自帶
    // @Bean(name = "Vincent")
    // RestTemplate restTemplate2() {
    //     return new RestTemplate();
    // }

    @Bean//(name = "lucas")
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // @Bean
    // ModelMapper ModelMapper() {
    //     return new ModelMapper();
    // }

    @Bean
    RedisManager redisManager(RedisConnectionFactory factory, ObjectMapper objectMapper) //
            throws JsonProcessingException {
        return new RedisManager(factory, objectMapper);
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
