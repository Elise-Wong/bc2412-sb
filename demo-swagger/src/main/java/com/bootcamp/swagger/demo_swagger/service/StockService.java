package com.bootcamp.swagger.demo_swagger.service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import com.bootcamp.swagger.demo_swagger.entity.StockEntity;

public interface StockService {
  Optional<StockEntity> findStock(String symbol);
  StockEntity saveStock(StockEntity stockEntity);
  void deleteStock(String symbol);
  StockEntity updateStock(String symbol, StockEntity stockEntity);
  StockEntity patchStockDescription(String symbol, String descreiption);
}
