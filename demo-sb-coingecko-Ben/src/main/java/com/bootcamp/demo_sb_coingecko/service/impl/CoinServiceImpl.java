package com.bootcamp.demo_sb_coingecko.service.impl;

import java.net.URI;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo_sb_coingecko.codewave.RedisManager;
import com.bootcamp.demo_sb_coingecko.model.Coin;
import com.bootcamp.demo_sb_coingecko.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisManager redisManager;

    // https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd
    //  coinurl = UriComponentsBuilder.newInstance()
        
    //@Value("${api.coingecko.domain}")


    @Override
    public List<Coin> getCoins() throws JsonProcessingException{

        Coin[] redisData = redisManager.get("gecko-coins", Coin[].class);
        if (redisData != null) {
            return Arrays.asList(redisData);
        }


        String url = UriComponentsBuilder.newInstance()
            .uri(URI.create("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd"))
            .build()
            .toUriString();
        // System.out.println("cointest");
        // System.out.println(url);

        redisManager.set("gecko-coins", redisData, Duration.ofMinutes(10));

        return Arrays.asList(this.restTemplate.getForObject(url, Coin[].class));

    }
    
}
