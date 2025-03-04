package com.bootcamp.demo_sb_customer.service.impl;

import com.bootcamp.demo_sb_customer.service.CalculatorService;

public class CalcuatorServiceImpl implements CalculatorService {
  
    // 用 copy 過黎, 記得寫 Override
    @Override
    public int sum(int x, int y) {
        return x + y;
    }

    @Override
    public int subtract(int x, int y) {
        return x - y;
    }
}
