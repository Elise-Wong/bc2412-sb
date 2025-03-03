package com.bootcamp.web.demo_coin_web.Service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.web.demo_coin_web.Service.CoinService;
import com.bootcamp.web.demo_coin_web.model.CoinData;
import com.bootcamp.web.demo_coin_web.model.dto.CoinGeckoMarketDto;

@Service
public class CoinServiceImpl implements CoinService{
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinGeckoMarketDto> getCoinMarket(){
    //String url = 
    //  "";
    //return Arrays.asList(this.restTemplate.getForObject(url, ))

    String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";
    CoinGeckoMarketDto[] response = restTemplate.getForObject(apiUrl, CoinGeckoMarketDto[].class);
    return Arrays.asList(response);
  }

  
}
