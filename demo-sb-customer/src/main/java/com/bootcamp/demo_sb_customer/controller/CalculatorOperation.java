package com.bootcamp.demo_sb_customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {

    @GetMapping(value = "/calculate/{x}/{y}")
    int calculate(@RequestParam int x, @RequestParam int y);
}
