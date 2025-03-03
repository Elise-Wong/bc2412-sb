package com.bootcamp.customer.demo_sb_customer.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.customer.demo_sb_customer.codewave.RedisManager;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  // ! Redis
  // key, value: <String , String>
  // Spring find the parameter dependency automatically
  // @Bean
  // RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){ //保留原本的<String , String> //自帶RedisConnectionFactory
  //   RedisTemplate<String, String> redisTemplate = new RedisTemplate<>(); //Must have
  //   redisTemplate.setConnectionFactory(factory); //must have
  //    //how to check string to 
  //   redisTemplate.setKeySerializer(RedisSerializer.string());
  //   redisTemplate.setValueSerializer((RedisSerializer.json()));
  //   redisTemplate.afterPropertiesSet();
  //   return redisTemplate;// return new RedisTemplate<>();

  // }

  //after hving RedisManager.class
  //全自動resolve dependant
  @Bean
  RedisManager redisManager(RedisConnectionFactory factory, ObjectMapper objectMapper){
    return new RedisManager(factory, objectMapper);
  }

  @Bean
  ObjectMapper objectMapper(){
    return new ObjectMapper();
  }






  
}
