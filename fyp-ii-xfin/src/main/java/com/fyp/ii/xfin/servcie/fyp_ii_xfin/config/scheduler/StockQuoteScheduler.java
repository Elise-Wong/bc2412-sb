package com.fyp.ii.xfin.servcie.fyp_ii_xfin.config.scheduler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockPriceEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper.StockPriceMapper;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.Stock;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.StockPriceRepository;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockAnsService;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.YFService;

@Component
public class StockQuoteScheduler {
  @Autowired
  private YFService yfService;
  @Autowired
  private StockPriceMapper stockPriceMapper; //
  @Autowired
  private StockAnsService stockAnsService;
  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Scheduled(fixedRate = 300_000)
  public void stockQuote() throws JsonProcessingException {
    List<Stock> stocks = this.stockAnsService.findAllWithCache();
    if (stocks == null || stocks.size() == 0){
      return;
    }
    List<String> symbols = stocks.stream()
      .map(s -> s.getSymbol())
      .collect(Collectors.toList());

    QuoteDTO quoteDTO = this.yfService.getQuote(symbols);
    quoteDTO.getBody().getResults().forEach(s -> {
      StockEntity stockEntity = this.stockAnsService.findBySymbol(s.getSymbol());
      StockPriceEntity stockPriceEntity = this.stockPriceMapper.map(s);
      stockPriceEntity.setStock(stockEntity);
      stockPriceEntity.setSymbol(stockEntity.getSymbol());
      stockPriceEntity.setTranType("5MIN");
      this.stockPriceRepository.save(stockPriceEntity);
    });
  }
  
}
