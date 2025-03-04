package com.bootcamp.demo_sb_customer.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_customer.codewave.RedisManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration // Bean
public class AppConfig {
    // more than one method for creating beans

    @Bean //想將佢變成 object 變成 bean
    BigDecimal bigDecimal() {
        return BigDecimal.valueOf(10);

    }

    @Bean
    String tutor() {
        return "Vincent";
    }

    // a single Bean, 2 String
    // @Bean
    // String tutor() {
    //     return "Lucas";
    // }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // @Bean
    // UserDTO map(UserDto dto) {
    //     return UserDTO;
    // }

    // add dependency
    // generic
    // key, value -> <String, String>
    // spring 會係 bean find the parameter dependeny automatically
    // @Bean
    // RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    //     RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    //     redisTemplate.setConnectionFactory(factory);
    //     redisTemplate.setKeySerializer(RedisSerializer.string());
    //     redisTemplate.setValueSerializer(RedisSerializer.json());
    //     redisTemplate.afterPropertiesSet();
    //     return redisTemplate;
    // }

    // spring 會 ensure 一定搵到
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
