package com.bootcamp.web.demo_coin_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
