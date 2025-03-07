package com.bootcamp.fypi.fyp_i_yfm.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YFinanceManager {
  @Autowired
  RestTemplate restTemplate;


  public YFinanceManager (){

  }

}
