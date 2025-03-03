package com.bootcamp.mtr.hw_sb_mtr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  // 1st Bean
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
  
}
