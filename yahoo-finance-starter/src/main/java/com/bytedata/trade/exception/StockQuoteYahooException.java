package com.bytedata.trade.exception;

import com.bytedata.trade.dto.YahooQuoteErrorDTO;
import com.bytedata.trade.lib.web.BusinessException;

public class StockQuoteYahooException extends BusinessException {
  public StockQuoteYahooException(YahooQuoteErrorDTO quoteErrorDTO) {
    super(YahooFinanceError.REST_CLIENT_EX,
        quoteErrorDTO.getBody().getError().getMessage());
  }
}
