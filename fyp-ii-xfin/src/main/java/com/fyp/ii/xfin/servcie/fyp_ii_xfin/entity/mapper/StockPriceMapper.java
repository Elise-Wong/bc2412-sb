package com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockPriceEntity;

@Component
public class StockPriceMapper {

  public StockPriceEntity map(QuoteDTO.QuoteBody.Result quotePrice){
    LocalDateTime quoteDateTime = LocalDateTime.ofInstant(
      Instant.ofEpochSecond(quotePrice.getRegularMarketTime()), 
      ZoneId.systemDefault());

    return StockPriceEntity.builder()
      .symbol(quotePrice.getSymbol())
      .tranDatetime(LocalDateTime.now())
      .marketUnixTime(quotePrice.getRegularMarketTime())
      .marketDateTime(quoteDateTime)
      .marketPrice(quotePrice.getRegularMarketPrice())
      .marketPriceChangePercent(quotePrice.getRegularMarketChangePercent())
      .ask(quotePrice.getAsk())
      .bid(quotePrice.getBid())
      .build();

  }
}
