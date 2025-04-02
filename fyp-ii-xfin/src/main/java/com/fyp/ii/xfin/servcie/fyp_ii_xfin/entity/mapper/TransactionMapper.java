package com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.TransactionEntity;

@Component
public class TransactionMapper {
  
  public TransactionEntity map(QuoteDTO.QuoteBody.Result quotePrice){
    LocalDateTime quoteDateTime = LocalDateTime.ofInstant(
      Instant.ofEpochSecond(quotePrice.getRegularMarketTime()), 
      ZoneId.systemDefault());

    return TransactionEntity.builder()
      .symbol(quotePrice.getSymbol())
      .tranDatetime(LocalDateTime.now())
      .marketUnixTime(quotePrice.getRegularMarketTime())
      .marketDateTime(quoteDateTime)
      .marketPrice(quotePrice.getRegularMarketPrice())
      .build();

  }

}
