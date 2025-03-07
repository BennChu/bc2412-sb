package com.bootcamp.demo.demo_thymeleaf.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
// @JsonIgnoreProperties(ignoreUnknown = true) 
public class CoinDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty("current_price")
  private Double currentPrice;
  @JsonProperty("market_cap")
  private Long marketCap;
}
