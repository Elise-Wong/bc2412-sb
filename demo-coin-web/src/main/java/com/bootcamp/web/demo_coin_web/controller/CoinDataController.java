package com.bootcamp.web.demo_coin_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootcamp.web.demo_coin_web.Service.ApiService;
import com.bootcamp.web.demo_coin_web.Service.impl.ApiServiceImpl;
import com.bootcamp.web.demo_coin_web.model.CoinData;
import com.bootcamp.web.demo_coin_web.model.dto.CoinGeckoMarketDto;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CoinDataController {

  private final ApiServiceImpl apiServiceImpl;

  @Autowired
  public CoinDataController(ApiServiceImpl apiServiceImpl){
    this.apiServiceImpl = apiServiceImpl;
  }
  
  // @GetMapping(value = "/coin-data")
  // public String displayExternalData(Model model) {
  //   List<CoinGeckoMarketDto> coinDataList = apiServiceImpl.fetchCoinData();
  //   model.addAttribute("coinList", coinDataList);
  //     return "coin-data";
  // }
  
}
