package com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper;

import org.springframework.stereotype.Component;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.Stock;

@Component
public class StockMapper {

  public Stock map(StockEntity entity){
    return Stock.builder()
      .id(entity.getId())
      .symbol(entity.getSymbol())
      .build();
  }
}
