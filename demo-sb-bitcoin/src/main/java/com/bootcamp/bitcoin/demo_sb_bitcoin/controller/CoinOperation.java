package com.bootcamp.bitcoin.demo_sb_bitcoin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.bitcoin.demo_sb_bitcoin.model.dto.CoinDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinOperation {
  @GetMapping(value = "/coins")
  List<CoinDto> getUsers() throws JsonProcessingException;
  //service agreement 

  

  
}
