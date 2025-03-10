package com.bootcamp.fypi.fyp_i_yfm.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.fypi.fyp_i_yfm.controller.CrumbOperation;
import com.bootcamp.fypi.fyp_i_yfm.manager.YCookiesManager;
import com.bootcamp.fypi.fyp_i_yfm.model.dto.CrumbDto;
import com.bootcamp.fypi.fyp_i_yfm.model.dto.QuoteDto;
import com.bootcamp.fypi.fyp_i_yfm.service.CrumbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CrumbController implements CrumbOperation{
  @Autowired
  private CrumbService crumbService;
  @Autowired
  private YCookiesManager yCookiesManager;


  @GetMapping(value = "/crumb")
  public CrumbDto getCrumb() {
    return this.crumbService.getCrumb();
    //return this.crumbService.fetchCrumb().getCrumb();
  }

  // @GetMapping(value = "/quote/{symbol}")
  // public QuoteDto getMethodName(@PathVariable String symbol) {
  //     return this.yCookiesManager.getQuote(symbol);
  // }
  

  @GetMapping(value = "/crumbKey")
  public String getCrumbKey() {
    return this.crumbService.getCrumbKey();
  }
  
  
}
