package com.bootcamp.web.demo_coin_web.Service;

import java.util.List;

import com.bootcamp.web.demo_coin_web.model.dto.CoinGeckoMarketDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinService {
  List<CoinGeckoMarketDto> getCoinMarket(); //throws JsonProcessingException
  

  
}
