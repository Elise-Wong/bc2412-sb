package com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.StockRepository;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockService;

@Service
public class StockServiceImpl implements StockService{ //task 2
  @Autowired
  private StockRepository stockRepository;

  @Override
  public void loadStockSymbols(List<String> stockSymbols) {

    try {
      // Create and save stock entities
      stockSymbols.forEach(symbol -> {
          StockEntity stock = new StockEntity(null,symbol); // null for id (因為自己jem)
          stockRepository.save(stock);
      });
      
      System.out.println("Successfully loaded " + stockSymbols.size() + " stock symbols");
      
      // Verify the data
      List<StockEntity> loadedStocks = stockRepository.findAll();
      System.out.println("Stocks in database:");
      loadedStocks.forEach(stock -> 
          System.out.println("Symbol: " + stock.getSymbol())
      );
      
  } catch (Exception e) {
      System.err.println("Error loading stock symbols: " + e.getMessage());
      throw e;
  }
  }

  @Override
  public void printSampleStocks() {
    List<StockEntity> loadedStocks = stockRepository.findAll();
    System.out.println("Stocks in database:");
    loadedStocks.forEach(stock -> 
        System.out.println("Symbol: " + stock.getSymbol())
    );
}
}
