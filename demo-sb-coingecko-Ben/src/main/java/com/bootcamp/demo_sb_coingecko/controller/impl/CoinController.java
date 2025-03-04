package com.bootcamp.demo_sb_coingecko.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_sb_coingecko.controller.CoinOperation;
import com.bootcamp.demo_sb_coingecko.model.Coin;
import com.bootcamp.demo_sb_coingecko.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CoinController implements CoinOperation {

    @Autowired
    private CoinService coinService;

    @Override
    public List<Coin> getCoins() throws JsonProcessingException{
        return this.coinService.getCoins();
    }
    
}
