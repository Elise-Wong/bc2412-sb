package com.fyp.ii.xfin.servcie.fyp_ii_xfin.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockService;

/*
@Component
public class PreServerStartConfig implements CommandLineRunner{ //task 2
  @Autowired
  private StockService stockService;
  @Autowired //task 3
  private RedisTemplate<String, Object> redisTemplate;

  @Override
  public void run(String... args) throws Exception{
    System.out.println("Hello!!!!!!");

    // Use command line args if provided, otherwise use default list
    List<String> stockSymbols = Arrays.asList(
      "0388.HK",
      "0700.HK",
      "0005.HK"
    );

    // Load stocks using service //task 2 by gpt
    stockService.loadStockSymbols(stockSymbols);
        
    // Print all stocks //task 2 by gpt
    stockService.printSampleStocks();

    // 清除 Redis 中的 STOCK-LIST //task 3 by gpt
    //stockService.clearStockList();
    redisTemplate.delete(stockSymbols);

    // 从数据库加载所有股票符号  //task 3 by gpt
    //stockService.loadStockSymbols(stockSymbols); //i dont think it needs


  }

  
  
}
 */ 