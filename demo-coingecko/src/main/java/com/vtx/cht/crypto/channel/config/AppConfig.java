package com.vtx.cht.crypto.channel.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.vtx.cht.crypto.channel.lib.RedisManager;

@Configuration
public class AppConfig {
  @Bean(name = "vincent")
  RestTemplate restTemplate2() {
    return new RestTemplate();
  }

  @Bean(name = "lucas")
  RestTemplate restTemplate1() {
    return new RestTemplate();
  }

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  // ! for Spring boot use (RestTemplate, Controller serialziation)
  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper() //
        .registerModule(new ParameterNamesModule()) //
        .registerModule(new Jdk8Module()) //
        .registerModule(new JavaTimeModule());
  }

  @Bean
  RedisManager redisManager(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisManager(factory, objectMapper);
  }
}
