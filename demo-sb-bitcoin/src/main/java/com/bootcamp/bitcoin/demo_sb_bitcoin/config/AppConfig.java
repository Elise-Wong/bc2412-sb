package com.bootcamp.bitcoin.demo_sb_bitcoin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.bitcoin.demo_sb_bitcoin.lib.RedisManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate(){ //Connection Pool
    return new RestTemplate();
  }

  // @Bean(value = "vin") // restTemplate1 becomes bean name, and now vin is bean name
  // RestTemplate restTemplate1(){ //Connection Pool
  //   return new RestTemplate();
  // }

  @Bean
  ObjectMapper objectMapper(){
    return new ObjectMapper();
  }
  
  @Bean
  RedisManager redisManager(RedisConnectionFactory factory, ObjectMapper objectMapper){
    // ObjectMapper objectMapper = new ObjectMapper()// 強行的, for redis
    //   .registerModule(new ParameterNamesModule())
    //   .registerModule(new Jdk8Module())
    //   .registerModule(new JavaTimeModule());
       
    return new RedisManager(factory, objectMapper);
  }


}
