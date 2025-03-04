package com.bootcamp.bc_forum.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO2 {

    private Long id;
    private String username;
    private List<Comment2> comments;

    @Getter
    @Builder
    public static class Comment2 {
        private String name;
        private String email;
        private String body;
    }
    
}
