package com.bootcamp.demo_candlestick.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_candlestick.model.CandleStick1DData;



@RestController
public class CandleStickController {
    @Autowired
    RestTemplate restTemplate;
    
    // http://localhost:8081/candlestick1d
    @GetMapping(value = "/candlestick1d")
    public String getData1D(Model model) { //
        String url = 
            "https://api.coingecko.com/api/v3/coins/bitcoin/ohlc?vs_currency=usd&days=1&x-cg-pro-api-key=CG-SyaMvK1V8kcA9MNue3H1NKXA";
        CandleStick1DData[] candleStick = this.restTemplate.getForObject(url, CandleStick1DData[].class);
        model.addAttribute(, candleStick)
        return "CandleStick1D.html";
    }
    
}
