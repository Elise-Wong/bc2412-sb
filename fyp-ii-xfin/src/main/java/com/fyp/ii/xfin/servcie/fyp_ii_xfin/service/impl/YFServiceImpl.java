package com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.manager.YFinanceManager;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.YFService;

@Service
public class YFServiceImpl implements YFService{
  @Autowired
  private YFinanceManager yFinanceManager;

  @Override
  public QuoteDTO getQuote(List<String> symbols) throws JsonProcessingException{
    return yFinanceManager.getQuote(symbols);
  }
  
}
