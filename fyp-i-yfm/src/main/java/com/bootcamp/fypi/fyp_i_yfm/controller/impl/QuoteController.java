package com.bootcamp.fypi.fyp_i_yfm.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.fypi.fyp_i_yfm.controller.QuoteOperation;
import com.bootcamp.fypi.fyp_i_yfm.model.dto.QuoteDto;
import com.bootcamp.fypi.fyp_i_yfm.service.CrumbService;
import com.bootcamp.fypi.fyp_i_yfm.service.QuoteService;

//@RestController
//@ResponseBody
public class QuoteController implements QuoteOperation {
  // @Autowired
  // private QuoteService quoteService;
  // @Autowired
  // private CrumbService crumbService; //

  // @GetMapping("/quote/{symbols}")
  // public QuoteDto getQuote(@PathVariable String symbols) {
  //     return this.quoteService.getQuote(symbols);
  // }



}
