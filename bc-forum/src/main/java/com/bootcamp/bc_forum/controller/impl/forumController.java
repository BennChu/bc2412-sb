package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.controller.forumOperation;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;
import com.bootcamp.bc_forum.service.UserService;

@RestController
public class forumController implements forumOperation {
    

    @Autowired
    private UserService userService;

    @Override
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @Override
    public List<Post> getAllPosts() {
        return this.userService.getAllPosts();
    }

    @Override
    public List<Comment> getAllComments() {
        return this.userService.getAllComments();
    }

}
