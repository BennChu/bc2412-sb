package com.bootcamp.demo.demo_sb_restful.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResult {
    
    private String message;

    // has lombok allargsconstructor
    // so just declare attribute
    // public ErrorResult(String message){
    //        this.message = message;
    //     }
    
}
