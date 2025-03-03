package com.bootcamp.bitcoin.demo_sb_bitcoin.service;

import java.util.List;

import com.bootcamp.bitcoin.demo_sb_bitcoin.model.dto.CoinDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinService {
  List<CoinDto> getUsers() throws JsonProcessingException;

  
}
