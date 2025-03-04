package com.bootcamp.web.demo_coin_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//
@Controller // return html
// @RestController
// RestController = Controller + Reponsebody 會 only 出 hello
public class ViewController {
    @GetMapping(value = "/bootcamp")
    public String sayHelloPage(Model model) { // pass by reference
        model.addAttribute("tutor", "vincent"); // set Vincent
        return "hello"; // html file name
    }
        
}
