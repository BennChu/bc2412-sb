package com.bootcamp.bc_forum.service;

import java.util.List;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;

public interface UserService {
    
    List<User> getAllUsers();

    List<Post> getAllPosts();

    List<Comment> getAllComments();
}
