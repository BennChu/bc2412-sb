package com.demo.sb_goodbye;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GoodByeController {

    // http://localhost:8080/goodbye
    @GetMapping(value = "/ipad/goodbye")
    public String goodbye() {
        return "GoodBye";
    }
    
}