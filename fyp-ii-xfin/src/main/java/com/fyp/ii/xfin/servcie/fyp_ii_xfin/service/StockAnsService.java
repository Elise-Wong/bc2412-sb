package com.fyp.ii.xfin.servcie.fyp_ii_xfin.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.Stock;

public interface StockAnsService {
  List<StockEntity> saveAll(List<StockEntity> entities);
  List<StockEntity> findAll();
  List<Stock> findAllWithCache() throws JsonProcessingException;
  StockEntity findBySymbol(String Symbol);
  
}
