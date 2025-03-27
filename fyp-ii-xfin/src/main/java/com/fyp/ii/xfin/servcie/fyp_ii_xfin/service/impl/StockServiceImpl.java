package com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.spel.ast.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.config.RedisManager;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper.StockMapper;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.Stock;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.StockRepository;
//import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockService;

/*
@Service
public class StockServiceImpl implements StockService{

  //private final ObjectMapper objectMapper; //task 2 (why no @Autowired?)
  private static final String REDIS_KEY = "STOCK-LIST";
  private static final long EXPIRATION_HOURS = 24;

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private StockMapper stockMapper;
  
  @Autowired  //task 2,3
  private StockRepository stockRepository;
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired  //task 3 3 by gpt
  private RedisTemplate<String, String> redisTemplate;
  // @Autowired
  // private TypeReference typeReference;

  //after hv library
  @Autowired
  private RedisManager redisManager; //but gpt doesnt say so

  /* 
    stockserviceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
  */

/*
  @Override  //task 2 by gpt
  public void loadstocksymbols(List<String> stocksymbols) {

    try {
      // Create and save stock entities
      stocksymbols.forEach(symbol -> {
        //因為StockEntity有2個attribute, 所以new時要都要有2個
          StockEntity stock = new StockEntity(null,symbol); // null for id (因為自己jem)
          stockRepository.save(stock);
      });
      
      System.out.println("Successfully loaded " + stocksymbols.size() + " stock symbols");
      
      // Verify the data
      List<StockEntity> loadedstocks = stockRepository.findAll();
      System.out.println("stocks in database:");
      loadedstocks.forEach(stock -> 
          System.out.println("Symbol: " + stock.getSymbol())
      );
      
  } catch (Exception e) {
      System.err.println("Error loading stock symbols: " + e.getMessage());
      throw e;
    }
  }
 */
/*
  @Override  //task 2 by gpt
  public void printSamplestocks() {
    List<StockEntity> loadedstocks = stockRepository.findAll();
    System.out.println("stocks in database:");
    loadedstocks.forEach(stock -> 
        System.out.println("Symbol: " + stock.getSymbol())
    );
  }
  */ 
/* 
 @Override
 public List<String> loadstocksymbols() {
  try {
      List<String> dbSymbols = stockRepository.findAllSymbols();
      String json = objectMapper.writeValueAsString(dbSymbols);
      redisTemplate.opsForValue().set(REDIS_KEY, json);
      redisTemplate.expire(REDIS_KEY, EXPIRATION_HOURS, TimeUnit.HOURS);
      return dbSymbols;
  } catch (JsonProcessingException e) {
      // 處理序列化失敗
      return new DataAccessException("Stock symbol serialization failed", e);
  }
}
  
  */


// @Override //x 
// public List<String> loadFromDatabaseWithFallback() {
//   try {
//       return stockRepository.findAllSymbols();
//   } catch (Exception e) {
//       // 雙重回退機制
//       return Collections.emptyList();
//   }
// }

/*
  @Override //task 3 by deepseek
  public List<String> getstocksymbols() { //get fr redis, can use Redis Manager
     // 先從Redis獲取
    String json = redisTemplate.opsForValue().get(REDIS_KEY);
    if (StringUtils.hasText(json)) {
        try {
              return objectMapper.readValue(json, new TypeReference<List<String>>(){});
            } catch (JsonProcessingException e) {
                // 處理反序列化失敗

                throw new RuntimeException("JSON解析失敗", e);
            }
        }
    // Redis不存在時從DB載入
    return loadstocksymbols();
  }
     */
/*
  @Override //task 3
  public List<String> getStockSymbols() throws JsonProcessingException{
    //Step 1: Read Redis first, if found, return users
    String json = redisTemplate.opsForValue().get(REDIS_KEY);
    String[] redisData = this.redisManager.get(REDIS_KEY, String[].class);

    //Step 2: if not found, call JPM
    if (redisData != null){
        return Arrays.asList(redisData);
    }

    List<Stock> stocks = Arrays.asList(this.restTemplate.getForObject(json, String[].class));

    // Save DB (procedures)
    stocks.stream().forEach(e -> {
      StockEntity stock = this.stockRepository.save(this.stockMapper.map(e));
    });

     // Clear DB : 由小至大
     this.stockRepository.deleteAll();
    
    //Step 3: Write the users back to redis
    this.redisManager.set(REDIS_KEY, stocks, Duration.ofMinutes(5));
    
    return stocks;
  }

}
 */