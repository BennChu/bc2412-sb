package com.bootcamp.demo.demo_sb_yahoo;

import org.springframework.web.client.RestTemplate;

public class YahooFinanceManager {
  private RestTemplate restTemplate;

  public YahooFinanceManager() {

  }

  public String quote(String symbol) {
    // cookie
    // crumb 
    // call quote API
    return "123";
  }
}
