package com.fyp.ii.xfin.servcie.fyp_ii_xfin.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.dto.QuoteDto;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.ResultRepository;
/* 
@Component
public class StockQuoteScheduler {
  @Autowired
  private final ResultRepository stockPriceRepository;
  @Autowired
  private QuoteDTO quoteDTO; //QuoteDto quoteDto

  public StockQuoteScheduler(ResultRepository stockPriceRepository) {
    this.stockPriceRepository = stockPriceRepository;
  }

  @Scheduled(fixedRate = 300000) // 5 minutes in milliseconds
  @Scheduled(cron = "0 35-59/5 8 * * MON-FRI", zone = "Asia/Hong_Kong")
  @Scheduled(cron = "0 0-59/5 9-11 * * MON-FRI", zone = "Asia/Hong_Kong")
  @Scheduled(cron = "0 0-59/5 13-15 * * MON-FRI", zone = "Asia/Hong_Kong")
  @Scheduled(cron = "0 0-5/5 16 * * MON-FRI", zone = "Asia/Hong_Kong")
  @Scheduled(cron = "0 15 10 ? * 6#3", zone = "Asia/Hong_Kong")
  public void fetchStockQuotes() {
      // Fetch stock symbols from Redis/table
      List<String> stockSymbols = fetchSymbolsFromRedis();

      for (String symbol : stockSymbols) {
          // Fetch stock data from Yahoo API
          QuoteDTO stockData = fetchStockDataFromYahoo(symbol);
          // Convert and save to the database
          QuoteDTO stockPrice = new QuoteDTO();
          stockPrice.setSymbol(symbol.getSymbol());
          stockPrice.setPrice(stockData.getPrice());
          stockPrice.setVolume(stockData.getVolume());
          //stockPrice.setType(QuoteDto.PriceType.M5);
          stockPrice.setApiDatetime(LocalDateTime.now());
          stockPrice.setMarketUnixTime(convertToTimestamp(stockData.getRegularMarketTime()));

          stockPriceRepository.saveAll(stockPrice);
      }
    }

  private List<String> fetchSymbolsFromRedis() {
        // Implement fetching symbols from Redis
  }

  private QuoteDTO fetchStockDataFromYahoo(String symbol) {
        // Implement fetching stock data from Yahoo API
  }

  private LocalDateTime convertToTimestamp(Long unixTime) {
    return LocalDateTime.ofEpochSecond(unixTime, 0, ZoneOffset.UTC);
  }


 
}

*/
