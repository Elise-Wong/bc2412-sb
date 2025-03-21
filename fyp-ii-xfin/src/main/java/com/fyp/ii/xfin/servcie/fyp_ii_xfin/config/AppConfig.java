package com.fyp.ii.xfin.servcie.fyp_ii_xfin.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.manager.YFinanceManager;

@Configuration
public class AppConfig {

  private final BigDecimal bigDecimal;
    AppConfig(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
  }

  @Bean
  BigDecimal bigDecimal(){
    return BigDecimal.valueOf(10);
  }

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  YFinanceManager yFinanceManager(){
    return new YFinanceManager();
  }

  //task 3 - fr gpt
  // @Bean
  // RedisCleaner redisCleaner(RedisTemplate<String, Object> redisTemplate){
  //   return new RedisCleaner(redisTemplate);
  // }

  //task 3
  @Bean
  RedisManager redisManager(RedisConnectionFactory factory, ObjectMapper objectMapper){
    return new RedisManager(factory, objectMapper);
  }

  @Bean
  ObjectMapper objectMapper(){
    return new ObjectMapper();
  }


  
}
