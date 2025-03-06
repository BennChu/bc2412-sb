package com.vtx.cht.crypto.channel.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtx.cht.crypto.channel.dto.CryptoWebDTO;
import com.vtx.cht.crypto.channel.model.CoinMarket;

@Component
public class DTOMapper {
  @Autowired
  private ModelMapper modelMapper;

  public CryptoWebDTO map(CoinMarket coinMarket) {
    return this.modelMapper.map(coinMarket, CryptoWebDTO.class);
  }
}
