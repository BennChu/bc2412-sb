package com.bootcamp.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;
import com.bootcamp.bc_forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.jsonplaceholder.domain}")
    private String domain;

    @Value("${api.jsonplaceholder.endpoints.users}")
    private String usersEndpoint;

    @Override
    public List<User> getAllUsers() {
        String url = UriComponentsBuilder.newInstance()
                        .scheme("https")
                        .host(domain)
                        .path(usersEndpoint)
                        .build()
                        .toUriString();

        return Arrays.asList(this.restTemplate.getForObject(url, User[].class));
    }



    
    @Value("${api.jsonplaceholder.endpoints.posts}")
    private String postsEndpoint;

    @Override
    public List<Post> getAllPosts() {
        String url = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host(domain)
                    .path(postsEndpoint)
                    .build()
                    .toUriString();

        return Arrays.asList(this.restTemplate.getForObject(url, Post[].class));
    }




    @Value("${api.jsonplaceholder.endpoints.comments}")
    private String commentsEndpoint;

    @Override
    public List<Comment> getAllComments() {
        String url = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host(domain)
                    .path(commentsEndpoint)
                    .build()
                    .toUriString();

        return Arrays.asList(this.restTemplate.getForObject(url, Comment[].class));
    }
}
