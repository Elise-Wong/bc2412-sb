package com.fyp.ii.xfin.servcie.fyp_ii_xfin.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;


public interface YFService {
  QuoteDTO getQuote(List<String> symbols) throws JsonProcessingException;
}
