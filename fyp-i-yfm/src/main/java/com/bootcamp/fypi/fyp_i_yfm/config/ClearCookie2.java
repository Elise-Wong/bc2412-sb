package com.bootcamp.fypi.fyp_i_yfm.config;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
public class ClearCookie2 {
  private static final String COOKIE = "B=12345abcde; GUC=AQEBCAFZ...";  // 你的 Cookie
  private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

  private RestTemplate restTemplate;

  public ClearCookie2(){

  }

  

  // public String getKey(){
 
  // HttpHeaders headers = new HttpHeaders();
  // headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
  // headers.set(HttpHeaders.COOKIE, COOKIE);

  // HttpEntity<String> entity = new HttpEntity<>(headers);
  // ResponseEntity<String> response = restTemplate.exchange(null, null);
  // return response.getBody();
  // }



}
