package com.bootcamp.demo.demo_sb_restful.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.Service.CalculatorService;
import com.bootcamp.demo.demo_sb_restful.model.Operation;
import com.bootcamp.demo.demo_sb_restful.model.ValueSet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// sum -> 1 + 2 = 3
// subract -> 1 - 2 = -1
// multiply -> 1 * 2 = 2
// divide -> 9 / 3 = 3

// Controller call service
// Marks the class as a REST controller. All methods in this class will return data directly.
@RestController // @RestController = @Controller + @ResponseBody
// @Controller -> During Server start -> Create an object of CalculatorController -> put it into context
// @ResponseBody -> meaning that every method in the class will return data directly to the client
@RequestMapping(value = "/v1") // letter 開頭
// Defines the base URL for all endpoints in this controller
// the return value of a method should be bound to the web response body.
// It tells Spring that the return value should be serialized directly
// into the HTTP response body
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    // this is query SUM?x=1&y=2
    // http://localhost:8082/v1/operation/SUM?x=1&y=2
    // @GetMapping(value = "/operation/{operation}")
    // public Integer operate(@PathVariable Operation operation,
    // //Operation.class is enum, 係 url 度要打岩, 如果唔岩會係
    // @RequestParam int x, @RequestParam int y) {//sum is not noun, may use addition

    // return this.calculatorService.operate(operation, x, y);

    // //at Json do not use int, no null value
    // // return switch (operation) {
    // // case SUM -> calculatorService.sum(x, y); //x + y;
    // // case SUBTRACT -> x - y;
    // // case MULTIPLY -> x * y;
    // // case DIVIDE -> {//y == 0 ? 0 : x / y; //need handle y is 0
    // // // int result = y == 0 ? 0 : x / y;
    // // // yield result;
    // // int result;
    // // try{
    // // result = x / y;

    // // } catch (ArithmeticException e) {
    // // result = 0;
    // // }
    // // yield result;

    // // }

    // // };
    // }



    // this is query SUM?x=1&y=2
    // http://localhost:8082/v1/operation/SUM?x=1&y=2
    @GetMapping("/operation/{operation}")
    public ValueSet operateQuery(@PathVariable Operation operation,
            @RequestParam Integer x, @RequestParam Integer y) {

        return new ValueSet(x, y, operation,
                this.calculatorService.operate(operation, x, y));
    }


    @PostMapping(value = "/operation")
    public ValueSet operate(@RequestBody ValueSet valueSet) {

        valueSet.setResult(this.calculatorService.operate(
                valueSet.getOperation(), valueSet.getX(), valueSet.getY()));

        return valueSet;
    }


    @GetMapping(value = "/operation/{x}/{y}/{operation}")
    public ValueSet operatePath(@PathVariable Operation operation,
            @PathVariable Integer x, @PathVariable Integer y) {
        // valueSet = new ValueSet(x, y, operation, 0);
        // valueSet.setX(x);
        // valueSet.setY(y);
        // valueSet.setOperation(operation);
        // valueSet.setResult(this.calculatorService.operate(operation, x, y));

        return new ValueSet(x, y, operation,
                (this.calculatorService.operate(operation, x, y)));
    }



}
