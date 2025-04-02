package com.fyp.ii.xfin.servcie.fyp_ii_xfin.config.scheduler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.TransactionEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper.TransactionMapper;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.Stock;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.TransactionRepository;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockAnsService;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.YFService;

@Component //ans: task 5
public class StockQuoteTranScheduler {
  @Autowired
  private YFService yfService;
  @Autowired
  private TransactionMapper transactionMapper; //
  @Autowired
  private StockAnsService stockAnsService;
  @Autowired
  private TransactionRepository transactionRepository;

  @Scheduled(fixedRate = 300_000) // 300/60=5min
  public void stockQuote() throws JsonProcessingException {
    List<Stock> stocks = this.stockAnsService.findAllWithCache();

    System.out.println("stocks" + stocks);

    if (stocks == null || stocks.size() == 0){
      return;
    }

    // ! Get All Symbols from DB (Cache Pattern)
    List<String> symbols = stocks.stream()
      .map(s -> s.getSymbol())
      .collect(Collectors.toList());

    // ! Get Price from Yahoo Finance (Direct Web Call)
    // Insert to tstocks_price one by one
    QuoteDTO quoteDTO = this.yfService.getQuote(symbols);
    quoteDTO.getBody().getResults().forEach(s -> {
      StockEntity stockEntity = this.stockAnsService.findBySymbol(s.getSymbol());
      TransactionEntity transactionEntity = this.transactionMapper.map(s);
      transactionEntity.setStock(stockEntity);
      transactionEntity.setSymbol(stockEntity.getSymbol());
      transactionEntity.setTranType("5MIN");
      this.transactionRepository.save(transactionEntity);
    });

    // ! Test for Task 6a (Get Sysdate by symbol)
    // for (String symbol : symbols) {
    //   System.out.println(
    //       "symbol=" + symbol + ", sysdate=" + systemService.getSysDate(symbol));
    // }

  }

}
