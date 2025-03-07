package com.bootcamp.fypi.fyp_i_yfm.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  @Bean
  BigDecimal bigDecimal(){
    return BigDecimal.valueOf(10);
  }

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
  
}
