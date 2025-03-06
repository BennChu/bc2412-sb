package com.vtx.cht.crypto.channel.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtx.cht.crypto.channel.model.CoinMarket;
import com.vtx.cht.crypto.channel.model.dto.CoinGeckoMarketDto;

@Component
public class CoreMapper {
  @Autowired
  private ModelMapper modelMapper;

  public CoinMarket map(CoinGeckoMarketDto dto) {
    return this.modelMapper.map(dto, CoinMarket.class);
  }
}
