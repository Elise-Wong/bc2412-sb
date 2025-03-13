package com.fyp.ii.xfin.servcie.fyp_ii_xfin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;

public interface StockPriceOperation {
  @GetMapping(value = "/stocks")
  List<QuoteDTO> getStocks();
  

  
}
