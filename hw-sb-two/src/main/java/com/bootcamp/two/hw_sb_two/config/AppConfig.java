package com.bootcamp.two.hw_sb_two.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  // 1st Bean
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate(); //for call API
  }
  
}
