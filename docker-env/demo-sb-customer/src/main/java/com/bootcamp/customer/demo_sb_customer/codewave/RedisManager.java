package com.bootcamp.customer.demo_sb_customer.codewave;


import java.time.Duration;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.NonNull;

import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisManager {
  private static final Duration DEFAULT_DURATION = Duration.ofHours(1);
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;

  public RedisManager(RedisConnectionFactory factory, ObjectMapper objectMapper){
    Objects.requireNonNull(factory); // = (@NonNull RedisConnectionFactory factory)
    Objects.requireNonNull(objectMapper); // 倚賴spring boot 的java programme
    this.redisTemplate = new RedisTemplate<>();
    this.redisTemplate.setConnectionFactory(factory); //must have
    this.redisTemplate.setKeySerializer(RedisSerializer.string());
    this.redisTemplate.setValueSerializer((RedisSerializer.json()));
    this.redisTemplate.afterPropertiesSet();
    this.objectMapper = objectMapper;
  }

  // UserDto userDto = new RestTemplate.getForObject(url, UserDto.class)
  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException { // T 是冇範圍
    String json = this.redisTemplate.opsForValue().get(key);
    return json == null ? null : objectMapper.readValue(json, clazz); //cant hv null
  }

  public void set(String key, Object object, Duration duration) throws JsonProcessingException {
    String serializedJson = objectMapper.writeValueAsString(object);
    //this.redisTemplate.opsForValue().set(key, serializedJson, duration);
    this.redisTemplate.opsForValue().set(key, serializedJson, DEFAULT_DURATION);
  }

}
