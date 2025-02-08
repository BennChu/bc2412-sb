package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.Arrays;
import java.util.List;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.DemoSbRestfulApplication;


@RestController
public class BeanController {

    // 睇下 CalculatorController and CatController 係咪 spring context 度
    @GetMapping(value = "/beans")
    public List<String> getBeans() {
        return Arrays.asList(DemoSbRestfulApplication
                            .context
                            .getBeanDefinitionNames());
    }
    
}
