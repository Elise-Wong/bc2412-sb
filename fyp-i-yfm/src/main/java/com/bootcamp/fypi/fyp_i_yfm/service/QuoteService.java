package com.bootcamp.fypi.fyp_i_yfm.service;

import com.bootcamp.fypi.fyp_i_yfm.model.dto.CrumbDto;
import com.bootcamp.fypi.fyp_i_yfm.model.dto.QuoteDto;

public interface QuoteService {

  QuoteDto getQuote(String symbols);

  
}
