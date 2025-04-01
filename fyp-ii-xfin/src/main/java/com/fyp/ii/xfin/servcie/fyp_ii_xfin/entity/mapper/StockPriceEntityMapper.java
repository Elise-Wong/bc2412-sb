package com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.QuoteEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.QuoteResponseEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.ResultEntity;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.dto.QuoteDto;

import org.springframework.stereotype.Component;

@Component // usenless?
public class StockPriceEntityMapper {

  public QuoteEntity map(QuoteDto dto){
    return QuoteEntity.builder()
      .build();
  }

  public QuoteResponseEntity map(QuoteDto.QuoteResponse quoteResponse){
    return QuoteResponseEntity.builder()
      .build();
  }

  public ResultEntity map(QuoteDto.QuoteResponse.Result result){
    return ResultEntity.builder()
      .symbol(result.getSymbol())
      .regularMarketTime(result.getRegularMarketTime())
      .regularMarketPrice(Double.valueOf(result.getRegularMarketPrice()))
      .regularMarketChange(result.getRegularMarketChange())
      .bid(Double.valueOf(result.getBid()))
      .ask(Double.valueOf(result.getAsk()))
      .build();
  }
  
}
