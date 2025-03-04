package com.bootcamp.bc_forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResult {
    private String code;
    private String name;
}
