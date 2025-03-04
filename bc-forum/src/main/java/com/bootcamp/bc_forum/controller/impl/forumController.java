package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.config.Validation;
import com.bootcamp.bc_forum.controller.forumOperation;
import com.bootcamp.bc_forum.dto.UserDTO;
import com.bootcamp.bc_forum.dto.UserDTO2;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;
import com.bootcamp.bc_forum.service.UserService;

@RestController
public class forumController implements forumOperation {
    

    @Autowired
    private UserService userService;
    @Autowired
    private Validation validation;

    @Override
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
    @Override
    public List<UserEntity> getAllUsersFromDB() {
        return this.userService.getAllUsersFromDB();
    }

    // Get user from DB by Id
    @Override
    public List<UserEntity> getUserFromDBById(@RequestParam Long id) {
        return this.userService.getUserFromDBById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return this.userService.getAllPosts();
    }

    @Override
    public List<Comment> getAllComments() {
        return this.userService.getAllComments();
    }

    @Override
    public List<UserDTO> getAll() {
        return this.userService.getAll();
    }

    @Override
    public UserDTO2 findCommentsByUserId(String id) {

        validation.input(id);
        
        Long x = Long.valueOf(id);
        validation.userId(x);

        return this.userService.getCommentsByUserId(x);
    }

    @Override
    public UserEntity putauser(@RequestBody UserEntity userEntity, @RequestParam Long id) {
        return this.userService.putauser(userEntity, id);
    }

}
