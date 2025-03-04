package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.bc_forum.dto.UserDTO;
import com.bootcamp.bc_forum.dto.UserDTO2;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;

public interface forumOperation {
    

    // http://localhost:8082/getallusers
    @GetMapping(value = "/getallusers")
    List<User> getAllUsers();

    // http://localhost:8082/getallusersfromdb
    // now is return from db, so return an Entity
    @GetMapping(value = "/getallusersfromdb")
    List<UserEntity> getAllUsersFromDB();

    // http://localhost:8082/getuserfromdbbyid?id=
    @GetMapping(value = "/getuserfromdbbyid")
    List<UserEntity> getUserFromDBById(@RequestParam Long id);

    // http://localhost:8082/getallposts
    @GetMapping(value = "/getallposts")
    List<Post> getAllPosts();

    // http://localhost:8082/getallcomments
    @GetMapping(value = "/getallcomments")
    List<Comment> getAllComments();

    // http://localhost:8082/getall
    @GetMapping(value = "/getall")
    List<UserDTO> getAll();

    // http://localhost:8082/findcommentsbyuserid?id=
    @GetMapping(value = "/findcommentsbyuserid")
    UserDTO2 findCommentsByUserId(@RequestParam String id);

    // Put a user (Replace existing user by a whole user object)
    // http://localhost:8082/putauser?id=
    @PostMapping(value = "/putauser")
    UserEntity putauser(@RequestBody UserEntity userEntity, @RequestParam Long id)

}
