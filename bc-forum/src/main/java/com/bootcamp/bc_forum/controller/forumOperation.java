package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;

public interface forumOperation {
    

    // http://localhost:8082/getallusers
    @GetMapping(value = "/getallusers")
    List<User> getAllUsers();

    // http://localhost:8082/getallposts
    @GetMapping(value = "/getallposts")
    List<Post> getAllPosts();

    // http://localhost:8082/getallcomments
    @GetMapping(value = "/getallcomments")
    List<Comment> getAllComments();

}
