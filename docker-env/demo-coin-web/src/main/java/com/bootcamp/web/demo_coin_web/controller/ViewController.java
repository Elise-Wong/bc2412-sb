package com.bootcamp.web.demo_coin_web.controller;

import java.util.List;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.web.demo_coin_web.Service.CoinService;
import com.bootcamp.web.demo_coin_web.model.dto.CoinGeckoMarketDto;


//@RestController //return JSON as response
@Controller // return html
public class ViewController {
  @Autowired
  private CoinService coinService;

  @GetMapping(value = "/bootcamp")
  //public String sayHelloPage(){
  public String sayHelloPage(Model model){  //Model (.ui)
    // select from DB, return list
    // put the list into model
    model.addAttribute("tutor", "vin");
    return "hello"; //html file name
  }

  // price change 24h , 3.23%(green)
  // price change 24h , -2.23%(red)
  @GetMapping(value = "/coins")
  public String coinPage(Model model) {
    List<CoinGeckoMarketDto> dtos = this.coinService.getCoinMarket();
    model.addAttribute("coinList", dtos);
      return "coin-data"; // html file name
  }
  
  
}
