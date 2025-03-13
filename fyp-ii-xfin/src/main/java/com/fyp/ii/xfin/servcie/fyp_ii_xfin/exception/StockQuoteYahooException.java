package com.fyp.ii.xfin.servcie.fyp_ii_xfin.exception;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.YahooQuoteErrorDTO;

public class StockQuoteYahooException extends BusinessException {
  public StockQuoteYahooException(YahooQuoteErrorDTO quoteErrorDTO) {
    super(YahooFinanceError.REST_CLIENT_EX,
        quoteErrorDTO.getBody().getError().getMessage());
  }
}
