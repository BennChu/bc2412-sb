package com.bootcamp.web.demo_coin_web.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.web.demo_coin_web.dto.CoinDataDto;
import com.bootcamp.web.demo_coin_web.model.CoinData;

@Component
public class CoinDataMapper {

    public CoinDataDto map(CoinData coinData) {
        return CoinDataDto.builder()
                .id(coinData.getId())
                .image(coinData.getImage())
                .currentPrice(coinData.getCurrentPrice())
                .priceChange24h(coinData.getPriceChange24h())
                .build();
    }
}
