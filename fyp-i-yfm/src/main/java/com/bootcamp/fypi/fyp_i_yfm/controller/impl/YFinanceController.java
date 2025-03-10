package com.bootcamp.fypi.fyp_i_yfm.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.fypi.fyp_i_yfm.manager.CrumbKeyManager;
import com.bootcamp.fypi.fyp_i_yfm.manager.YFinanceManager;
import com.bootcamp.fypi.fyp_i_yfm.model.dto.QuoteDto;

@RestController
@ResponseBody
public class YFinanceController {
  @Autowired
  CrumbKeyManager crumbKeyManager;
  @Autowired
  YFinanceManager yFinanceManager;

  @GetMapping("/quote/{symbols}")
  public QuoteDto getMethodName(@PathVariable String symbols) {
      return this.yFinanceManager.getQuote(symbols);
  }
  
}
