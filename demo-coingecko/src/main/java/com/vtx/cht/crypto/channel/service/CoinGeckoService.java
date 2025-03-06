package com.vtx.cht.crypto.channel.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtx.cht.crypto.channel.model.CoinMarket;

public interface CoinGeckoService {
  List<CoinMarket> getCoinMarket();

  List<CoinMarket> getCoinMarketWithCache() throws JsonProcessingException;
}
