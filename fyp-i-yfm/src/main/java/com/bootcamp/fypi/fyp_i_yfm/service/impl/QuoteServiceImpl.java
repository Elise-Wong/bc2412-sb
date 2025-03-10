package com.bootcamp.fypi.fyp_i_yfm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.fypi.fyp_i_yfm.model.dto.QuoteDto;

@Service
public class QuoteServiceImpl {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private CrumbServiceImpl crumbServiceImpl;

  //cookies=fc.yahoo.com
  private static final String COOKIE = "B=12345abcde; GUC=AQEBCAFZ...";  // 你的 Cookie = hard code
  private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
  
  public QuoteDto getQuote(String symbols){
    this.crumbServiceImpl.getCrumb();
    String crumbKey = crumbServiceImpl.CRUMBKEY;
    String url = String
    .format("https://query1.finance.yahoo.com/v7/finance/quote?symbols=%s.HK&crumb=%s"
    , symbols,crumbKey);
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
    headers.set(HttpHeaders.COOKIE, COOKIE);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<QuoteDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, QuoteDto.class);
    return response.getBody();
  }


}
