package com.bootcamp.bc_forum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.bc_forum.dto.UserDTO;
import com.bootcamp.bc_forum.dto.UserDTO2;
import com.bootcamp.bc_forum.dto.UserDTO2.Comment2;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;
import com.bootcamp.bc_forum.repository.UserRepository;
import com.bootcamp.bc_forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    //@Autowired
    //private UserDTOMapper userDTOMapper;
    @Autowired
    private UserRepository userRepository;
    
    @Value("${api.jsonplaceholder.domain}")
    private String domain;

    @Value("${api.jsonplaceholder.endpoints.users}")
    private String usersEndpoint;

    private String userurl;
    private String posturl;
    private String commenturl;

    // Get all users
    @Override
    public List<User> getAllUsers() {
        userurl = UriComponentsBuilder.newInstance()
                        .scheme("https")
                        .host(domain)
                        .path(usersEndpoint)
                        .build()
                        .toUriString();

        return Arrays.asList(this.restTemplate.getForObject(userurl, User[].class));
    }

    // Get all users from database
    @Override
    public List<UserEntity> getAllUsersFromDB() {
        return this.userRepository.findAll();
    }

    // Get user from database by Id
    public List<UserEntity> getUserFromDBById(Long id) {
        
        Optional<UserEntity> result = this.userRepository.findById(id);
        if (result.isPresent())
            return Arrays.asList(result.get());

        return null;
    }

    @Value("${api.jsonplaceholder.endpoints.posts}")
    private String postsEndpoint;

    @Override
    public List<Post> getAllPosts() {
        posturl = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host(domain)
                    .path(postsEndpoint)
                    .build()
                    .toUriString();

        return Arrays.asList(this.restTemplate.getForObject(posturl, Post[].class));
    }




    @Value("${api.jsonplaceholder.endpoints.comments}")
    private String commentsEndpoint;

    @Override
    public List<Comment> getAllComments() {
        commenturl = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host(domain)
                    .path(commentsEndpoint)
                    .build()
                    .toUriString();

        return Arrays.asList(this.restTemplate.getForObject(commenturl, Comment[].class));
    }


    @Override
    public List<UserDTO> getAll() {

        String userurl1 = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .path(usersEndpoint)
            .build()
            .toUriString();

        String posturl1 = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .path(postsEndpoint)
            .build()
            .toUriString();   
            
        String commenturl1 = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .path(commentsEndpoint)
            .build()
            .toUriString(); 

                        

        List<User> users = Arrays.asList(this.restTemplate.getForObject(userurl1, User[].class));
        List<Post> posts = Arrays.asList(this.restTemplate.getForObject(posturl1, Post[].class));
        List<Comment> comments = Arrays.asList(this.restTemplate.getForObject(commenturl1, Comment[].class));

        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {

            // build Geo object
            UserDTO.Address.Geo userAddressGeo = UserDTO.Address.Geo.builder()
                .lat(user.getAddress().getGeo().getLat())
                .lng(user.getAddress().getGeo().getLng())
                .build();

            UserDTO.Address userAddress = UserDTO.Address.builder()
                .street(user.getAddress().getStreet())
                .suite(user.getAddress().getSuite())
                .city(user.getAddress().getCity())
                .zipcode(user.getAddress().getZipcode())
                .geo(userAddressGeo)
                .build();

            UserDTO.Company userCompany = UserDTO.Company.builder()
                .name(user.getCompany().getName())
                .catchPhrase(user.getCompany().getCatchPhrase())
                .bs(user.getCompany().getBs())
                .build();

            UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(userAddress)
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(userCompany);

                
                List<UserDTO.Post> userPosts = new ArrayList<>();

                for (Post post : posts) {

                    if (user.getId() == post.getUserId()) { // post.getUserid().equals(user.getId())

                        List<UserDTO.Post.Comment> postComments = new ArrayList<>();
                    
                        // add each comment to a List postComments
                        for (Comment comment : comments) {
                            if (comment.getPostId() == post.getId()) { //  comment.getPostid().equals(post.getId())
                                postComments.add(UserDTO.Post.Comment.builder()
                                                    .id(comment.getId())
                                                    .postId(comment.getPostId())
                                                    .name(comment.getName())
                                                    .email(comment.getEmail())
                                                    .body(comment.getBody())
                                                    .build()); //this.userDTOMapper.map(comment)
                            }
                        }    

                        UserDTO.Post userPost = UserDTO.Post.builder()
                                                    .userId(post.getUserId())                            
                                                    .id(post.getId())
                                                    .title(post.getTitle())
                                                    .body(post.getBody())
                                                    .comments(postComments)
                                                    .build();

                        userPosts.add(userPost);
                    }

                }

                userDTOBuilder.posts(userPosts);
                userDTOs.add(userDTOBuilder.build());
        }

        return userDTOs;
    }

    @Override
    public UserDTO2 getCommentsByUserId(Long x) {

        // users url
        String userurl1 = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .path(usersEndpoint)
            .build()
            .toUriString();

        // posts url
        String posturl1 = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .path(postsEndpoint)
            .build()
            .toUriString();   
            
        // comments url
        String commenturl1 = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .path(commentsEndpoint)
            .build()
            .toUriString();

        // put data into List
        List<User> users = Arrays.asList(this.restTemplate.getForObject(userurl1, User[].class));
        List<Post> posts = Arrays.asList(this.restTemplate.getForObject(posturl1, Post[].class));
        List<Comment> comments = Arrays.asList(this.restTemplate.getForObject(commenturl1, Comment[].class));

        // find the user
        List<User> users2 = users.stream().filter(e -> e.getId() == x).collect(Collectors.toList());
        // list for all posts match with user id
        List<Post> posts2 = posts.stream().filter(e -> e.getUserId() == x).collect(Collectors.toList());
       
        // list for all comments match with post id
        List<Comment2> result = new ArrayList<>();

        for (Post post : posts2) {
            for (Comment comment : comments) {
                if (comment.getPostId() == post.getId()) {
                    result.add(Comment2.builder().name(comment.getName())
                                    .email(comment.getEmail())
                                    .body(comment.getBody())
                                    .build());
                }
            }
            
        }

        // create List for result
        UserDTO2.UserDTO2Builder userDTO2s = UserDTO2.builder()
                                            .id(x)
                                            .username(users2.get(0).getUsername())
                                            .comments(result);

        return userDTO2s.build();
    }

    @Override
    public UserEntity putauser(UserEntity userEntity, Long id) {

        if (this.userRepository.existsById(id)) {
            // findById return Optional
            UserEntity newEntity = this.userRepository.findById(id).get();
                        
            newEntity.setName(userEntity.getName());
            newEntity.setUsername(userEntity.getUsername());
            newEntity.setEmail(userEntity.getEmail());
            newEntity.setPhone(userEntity.getPhone());
            newEntity.setWebsite(userEntity.getWebsite());
        
            return this.userRepository.save(newEntity);

        }
        return null;
    }
}
