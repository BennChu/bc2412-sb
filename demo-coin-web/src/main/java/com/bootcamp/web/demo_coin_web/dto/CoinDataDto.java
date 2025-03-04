package com.bootcamp.web.demo_coin_web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CoinDataDto {
    private String id;
    private String image;
    private Double currentPrice;
    private Double priceChange24h;
    
}
