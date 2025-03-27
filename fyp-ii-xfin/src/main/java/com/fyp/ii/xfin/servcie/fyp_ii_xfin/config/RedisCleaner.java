package com.fyp.ii.xfin.servcie.fyp_ii_xfin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.impl.StockServiceImpl;

//@Component
public class RedisCleaner implements CommandLineRunner{ //task 3 by Chatgpt
    
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisCleaner(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.delete("STOCK-LIST");
    }
  
}
