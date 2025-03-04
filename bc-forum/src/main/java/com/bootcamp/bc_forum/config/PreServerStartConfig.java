package com.bootcamp.bc_forum.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;
import com.bootcamp.bc_forum.repository.CommentRepository;
import com.bootcamp.bc_forum.repository.CompanyRepository;
import com.bootcamp.bc_forum.repository.PostRepository;
import com.bootcamp.bc_forum.repository.UserRepository;
import com.bootcamp.bc_forum.service.UserService;

@Component // Bean context
public class PreServerStartConfig implements CommandLineRunner{
    
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    // @Autowired
    // private GeoRepository geoRepository;
    // @Autowired
    // private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    

    @Override
    public void run(String... args) throws Exception {
            
        // 原本有 data, 所以 delete 先, 做 testing
        // this.geoRepository.deleteAll();
        //this.addressRepository.deleteAll();
        this.companyRepository.deleteAll();
        this.commentRepository.deleteAll();
        this.postRepository.deleteAll();
        this.userRepository.deleteAll();

        List<User> users = userService.getAllUsers();
    
        for (User user : users) {

            // GeoEntity geoEntity = GeoEntity.builder()
            //                         .lat(user.getAddress().getGeo().getLat())
            //                         .lng(user.getAddress().getGeo().getLng())
            //                         .build();

            // AddressEntity addressEntity = //
            //     AddressEntity.builder()
            //     .street(user.getAddress().getStreet())
            //     .city(user.getAddress().getCity())
            //     .suite(user.getAddress().getSuite())
            //     .zipcode(user.getAddress().getZipcode())
            //     //.geoEntity(geoEntity)
            //     .build();

            UserEntity userEntity = //
                UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                //.addressEntity(addressEntity)
                .phone(user.getPhone())
                .website(user.getWebsite())
                .build();

            this.userRepository.save(userEntity);

            // for insert into post
            List<Post> posts = userService.getAllPosts(); 

            for (Post post : posts) {
                if (user.getId() == post.getUserId()) { // if (user.getId().equals(post.getUserId()))
                    
                    PostEntity postEntity = PostEntity.builder()
                                                .id(post.getId())
                                                .title(post.getTitle())
                                                .body(post.getBody())
                                                .userEntity(userEntity)
                                                .build();
                    postRepository.save(postEntity);
                
                    List<Comment> comments = userService.getAllComments();
                    for (Comment comment : comments) {
                        if (comment.getPostId() == post.getId()) { // comment.getPostId().equals(post.getId())
                            commentRepository.save(CommentEntity.builder()
                                                        .id(comment.getId())
                                                        .name(comment.getName())
                                                        .email(comment.getEmail())
                                                        .body(comment.getBody())
                                                        .postEntity(postEntity)
                                                        .build());
            
                        }
                    }
                }

                
                
            }
    

        }
      
                

    }
    
}
