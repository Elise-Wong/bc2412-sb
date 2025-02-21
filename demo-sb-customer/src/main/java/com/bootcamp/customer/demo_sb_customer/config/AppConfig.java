package com.bootcamp.customer.demo_sb_customer.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//create bean before server start


@Configuration //bean
public class AppConfig { //usually for external class 人地寫好的code, 然後download 落黎
  // ! more than 1 methods for creating beans
  @Bean
  BigDecimal bigDecimal(){
    return BigDecimal.valueOf(10);
  }

  @Bean
  String tutor(){ //如果有2個string就會炒車, 因為string好大眾, 係垃圾筒找
    return "Vincent";
  }

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }




  
}
