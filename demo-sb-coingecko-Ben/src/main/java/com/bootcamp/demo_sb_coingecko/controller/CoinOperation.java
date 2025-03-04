package com.bootcamp.demo_sb_coingecko.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo_sb_coingecko.model.Coin;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinOperation {
    @CrossOrigin // this is from spring
    // http://localhost:8081/getcoins
    @GetMapping(value = "/getcoins")
    List<Coin> getCoins() throws JsonProcessingException;

}
