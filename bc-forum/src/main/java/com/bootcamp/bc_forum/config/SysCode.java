package com.bootcamp.bc_forum.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SysCode {
    USER_NOT_FOUND("1", "User not found."),
    INVALID_INPUT("2", "Invalid Input."),
    RESTTEMPLATE_ERROR("3", "RestTemplate Error - JsonPlaceHolder"),
    ;

    private final String code;
    private final String message;


}
