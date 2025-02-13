package com.bootcamp.bc_forum.model;

import lombok.Getter;

@Getter
public class Comment {
    private Long positid;
    private Long id;
    private String name;
    private String email;
    private String body;
}
