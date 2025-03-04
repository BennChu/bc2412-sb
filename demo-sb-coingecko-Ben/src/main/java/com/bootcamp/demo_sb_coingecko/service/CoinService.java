package com.bootcamp.demo_sb_coingecko.service;

import java.util.List;
import com.bootcamp.demo_sb_coingecko.model.Coin;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinService {
    
    List<Coin> getCoins() throws JsonProcessingException;
}
