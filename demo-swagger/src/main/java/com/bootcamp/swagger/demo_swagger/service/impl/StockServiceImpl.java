package com.bootcamp.swagger.demo_swagger.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.swagger.demo_swagger.entity.StockEntity;
import com.bootcamp.swagger.demo_swagger.repository.StockRepository;
import com.bootcamp.swagger.demo_swagger.service.StockService;

@Service
public class StockServiceImpl implements StockService{
  @Autowired
  private StockRepository stockRepository;

  @Override
  public Optional<StockEntity>findStock(String symbol){
  //public StockEntity findStock(String symbol){
    return stockRepository.findById(symbol);
  }

  @Override
  public StockEntity saveStock(StockEntity entity){
    return this.stockRepository.save(entity);
  }

  @Override
  public void deleteStock(String symbol){
    this.stockRepository.deleteById(symbol);
  }

  @Override
  public StockEntity updateStock(String symbol, StockEntity stockEntity){
    if (this.stockRepository.existsById(symbol)){
      throw new NoSuchElementException(symbol + "is not found.");
    } 
    return this.stockRepository.save(stockEntity);
  }

  @Override
  public StockEntity patchStockDescription(String symbol, String descreiption){
    Optional<StockEntity> entity = this.stockRepository.findById(symbol);
    if (!entity.isPresent()){
      throw new NoSuchElementException(symbol + "is not found.");
    } 
    entity.get().setDescription(descreiption);
    return this.stockRepository.save(entity.get());
  }

  
}
