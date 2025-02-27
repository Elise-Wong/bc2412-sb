package com.vtx.cht.crypto.channel.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtx.cht.crypto.channel.dto.CryptoWebDTO;

public interface CryptoWebOperation {
  @GetMapping("/coin/market")
  List<CryptoWebDTO> getCoinMarket();

  @GetMapping("/cache/coin/market")
  List<CryptoWebDTO> getCoinMarketWithCache() throws JsonProcessingException;
}
