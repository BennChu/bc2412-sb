package com.bootcamp.demo_sb_customer.config;

import java.math.BigDecimal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


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

}
