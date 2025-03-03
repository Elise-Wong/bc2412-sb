package com.bootcamp.bitcoin.demo_sb_bitcoin.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.bitcoin.demo_sb_bitcoin.lib.RedisManager;
import com.bootcamp.bitcoin.demo_sb_bitcoin.model.dto.CoinDto;
import com.bootcamp.bitcoin.demo_sb_bitcoin.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CoinServiceImpl implements CoinService{
  @Autowired
  //@Qualifier(value = "vin")
  private RestTemplate restTemplate;
  @Autowired
  private RedisTemplate<String, String> redisTemplate;
  @Autowired
  private RedisManager redisManager;


  @Value("${api.jph.domain}")
  private String domain;

  @Value("${api.jph.endpoints.coinsmarkets}")
  private String coinsMarketsEndpoint;

  @Override
  public List<CoinDto> getUsers() throws JsonProcessingException{

    CoinDto[] redisData = this.redisManager.get("jph-users", CoinDto[].class);
    if (redisData != null) {
      return Arrays.asList(redisData);
    }

    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(coinsMarketsEndpoint)
      .build()
      .toUriString();
    //return Arrays.asList(this.restTemplate.getForObject(url, CoinDto[].class));
    List<CoinDto> coinDtos = Arrays.asList(this.restTemplate.getForObject(url, CoinDto[].class));

    //getForEntity: can check getStatus (200) + if (reflow)
    //more low level: postForObject
    //requestBody=POST 你call人

    this.redisManager.set("jph-users", coinDtos, Duration.ofMinutes(3));
    return coinDtos;

  }

}
