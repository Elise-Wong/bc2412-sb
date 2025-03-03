package com.bootcamp.bitcoin.demo_sb_bitcoin.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.bitcoin.demo_sb_bitcoin.controller.CoinOperation;
import com.bootcamp.bitcoin.demo_sb_bitcoin.model.dto.CoinDto;
import com.bootcamp.bitcoin.demo_sb_bitcoin.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CoinController implements CoinOperation{
  @Autowired
  private CoinService coinService;

  @GetMapping(value = "/coins")
  public List<CoinDto> getUsers() throws JsonProcessingException{
      return this.coinService.getUsers();
  }
  
  
}
