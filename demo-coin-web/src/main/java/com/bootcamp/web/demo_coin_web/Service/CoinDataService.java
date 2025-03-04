package com.bootcamp.web.demo_coin_web.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.web.demo_coin_web.dto.CoinDataDto;
import com.bootcamp.web.demo_coin_web.dto.mapper.CoinDataMapper;
import com.bootcamp.web.demo_coin_web.model.CoinData;

@Service
public class CoinDataService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CoinDataMapper coinDataMapper;

    public List<CoinData> fetchCoinData() {
        String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd"; 
        CoinData[] response = restTemplate.getForObject(apiUrl, CoinData[].class);
        return Arrays.asList(response);
    }

    public List<CoinDataDto> fetchCoinSnapData() {
        List<CoinData> response1 = this.fetchCoinData();
        return response1.stream().map(coinData -> coinDataMapper.map(coinData))
                       .collect(Collectors.toList());
        
    }
}
