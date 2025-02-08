package com.bootcamp.demo.demo_sb_restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.Service.CalculatorService;
import com.bootcamp.demo.demo_sb_restful.model.Operation;

// sum -> 1 + 2 = 3
// subract -> 1 - 2 = -1
// multiply -> 1 * 2 = 2
// divide -> 9 / 3 = 3

//Controller call service
@RestController // @RestController = @Controller + @ResponseBody
// @Controller -> During Server start -> Create an object of CalculatorController -> put it into context
@RequestMapping(value = "/v1")//letter 開頭

public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    // http://localhost:8082/v1/operation/SUM?x=1&y=2
    @GetMapping(value = "/operation/{operation}")
    public Integer operate(@PathVariable Operation operation, 
                            //Operation.class is enum, 係 url 度要打岩, 如果唔岩會係
                            @RequestParam int x, @RequestParam int y) {//sum is not noun, may use addition
    
        return this.calculatorService.operate(operation, x, y);
    
        //at Json do not use int, no null value
        // return switch (operation) {
        //     case SUM      -> calculatorService.sum(x, y); //x + y;
        //     case SUBTRACT -> x - y;
        //     case MULTIPLY -> x * y;
        //     case DIVIDE   -> {//y == 0 ? 0 : x / y;    //need handle y is 0
        //             //  int result = y == 0 ? 0 : x / y;
        //             //     yield result;
        //                 int result;
        //                 try{
        //                     result = x / y;
                            
        //                 } catch (ArithmeticException e) {
        //                     result = 0;
        //                 }
        //                 yield result;

        //             }

        // };  
    }


}
