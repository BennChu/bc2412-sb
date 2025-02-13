package com.bootcamp.demo_sb_customer.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class BeanController {
    
    @Autowired // wired 左去 Vincent
    private String abc;
    
    
    @PostMapping(value = "/bean/tutor")
    public String getTutor() {        
        return abc;
    }
    
}
