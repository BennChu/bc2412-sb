package com.bootcamp.bc_forum.service;

import java.util.List;
import com.bootcamp.bc_forum.dto.UserDTO;
import com.bootcamp.bc_forum.dto.UserDTO2;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;

public interface UserService {
    
    // implicit public no need public
    List<User> getAllUsers();

    List<UserEntity> getAllUsersFromDB();

    List<UserEntity> getUserFromDBById(Long id);

    List<Post> getAllPosts();

    List<Comment> getAllComments();

    List<UserDTO> getAll();    

    UserDTO2 getCommentsByUserId(Long x);

    UserEntity putauser(UserEntity userEntity, Long id);
}
