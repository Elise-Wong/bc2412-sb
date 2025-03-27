package com.fyp.ii.xfin.servcie.fyp_ii_xfin.controller.impl;

import java.text.Collator;
import java.util.List;

import org.aspectj.internal.lang.annotation.ajcITD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.controller.StockPriceOperation;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
//import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockPriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 
@RestController
public class StockPriceController implements StockPriceOperation{
  @Autowired
  private StockPriceService stockPriceService;
  @Autowired
  private QuoteDTO quoteDTO;
  
  @GetMapping(value = "/stocks")
  public List<QuoteDTO> getStocks() {
      return this.stockPriceService.getStock().stream()
        .map(e -> quoteDTO.map(e))
        .collect(Collator.toList());
  }
  

}
*/