package com.bootcamp.demo_sb_coingecko.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonNaming(value = SnakeCaseStrategy.class) // auto 轉 "Market_cap" to marketCap, number 轉唔到
public class Coin {

    private String id;
    private String symbol;
    private String name;
    private String image;
    private Double currentPrice;
    private Double marketCap;
    private Integer marketCapRank;
    private Long fullyDilutedValuation;
    private Long totalVolume;
    @JsonProperty(value = "high_24h")
    private Double high24h;
    @JsonProperty(value = "low_24h")
    private Double low24h;
    @JsonProperty(value = "price_change_24h")
    private Double priceChange24h;
    @JsonProperty(value = "price_change_percentage_24h")
    private Double priceChangePercentage24h;
    @JsonProperty(value = "market_cap_change_24h")
    private Double marketCapChange24h;
    @JsonProperty(value = "market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;
    private Double circulatingSupply;
    private Double totalSupply;
    private Double maxSupply;
    private Double ath;
    private Double athChangePercentage;
    private String athDate;
    private Double atl;
    private Double atlChangePercentage;
    private String atlDate;
    private Roi roi;
    private String lastUpdated;

    @Getter
    @Builder
    public static class Roi {
        private Double times;
        private String currency;
        private Double percentage;
    }
}
