package com.bootcamp.bc_forum.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.bc_forum.exception.NoIdException;
import com.bootcamp.bc_forum.model.User;

@Component
public class Validation {

    // should declared at class level
    @Autowired
    private RestTemplate restTemplate;


    @Value("${api.jsonplaceholder.domain}")
    private String domain;

    @Value("${api.jsonplaceholder.endpoints.users}")
    private String usersEndpoint;



    public void userId(Long id) {

        String userurl = UriComponentsBuilder.newInstance()
                        .scheme("https")
                        .host(domain)
                        .path(usersEndpoint)
                        .build()
                        .toUriString();

        List<User> users = Arrays.asList(this.restTemplate.getForObject(userurl, User[].class));

        if (users.stream().noneMatch(user -> user.getId().equals(id))) {
            throw new NoIdException(SysCode.USER_NOT_FOUND);
        }
            
    }

    public void input(String id) {
        Long.parseLong(id);
    }
    
}
