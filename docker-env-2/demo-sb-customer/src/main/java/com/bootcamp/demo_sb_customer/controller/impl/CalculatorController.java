package com.bootcamp.demo_sb_customer.controller.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_sb_customer.controller.CalculatorOperation;

// 有人 Autowired 
// @Autowired(required = false)
// then mehtod will call calculatorOperation.xxx()

@RestController
public class CalculatorController implements CalculatorOperation {
    
    @Override
    public int calculate(@RequestParam int x, @RequestParam int y) {
        return sum(x, y) + subtract(x, y); // if unit test, we test '+', '+' is value add
                                          // sum(x, y) is tested below
                                          // here is we assume sum 出 100, abstract 出 200
                                          // 結果係出 300
    }

    // we have unit test for sum

    private int sum(int x, int y) {
        return x + y;
    }

    // we have unit test for subtract
    private int subtract(int x, int y) {
        return x - y;
    }

}
