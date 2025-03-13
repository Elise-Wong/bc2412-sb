package com.fyp.ii.xfin.servcie.fyp_ii_xfin.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockService;


@Component
public class PreServerStartConfig implements CommandLineRunner{ //task 2
  @Autowired
  private StockService stockService;

  @Override
  public void run(String... args) throws Exception{
    System.out.println("Hello!!!!!!");

    // Use command line args if provided, otherwise use default list
    List<String> stockSymbols = Arrays.asList(
      "0388.HK",
      "0700.HK",
      "0005.HK"
    );

    // Load stocks using service
    stockService.loadStockSymbols(stockSymbols);
        
    // Print all stocks
    stockService.printSampleStocks();
  }

  
  
}
 