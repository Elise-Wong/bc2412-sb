package com.bootcamp.fypi.fyp_i_yfm.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.fypi.fyp_i_yfm.config.ClearCookies;

@Component
public class CrumbKeyManager {
  @Autowired
  private RestTemplate restTemplate;
  //private ClearCookies clearCookies;

  //public CrumbKeyManager(){

  //}

  //cookie
  //crum
  //call quote API

  private static final String COOKIE = "B=12345abcde; GUC=AQEBCAFZ...";  // 你的 Cookie
  private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
  public static String CRUMBKEY;
  
  public String getCrumbKey(){
    String url = "https://query1.finance.yahoo.com/v1/test/getcrumb";
    
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
    headers.set(HttpHeaders.COOKIE, COOKIE);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    CRUMBKEY = response.getBody();
    return response.getBody();
  }

}
