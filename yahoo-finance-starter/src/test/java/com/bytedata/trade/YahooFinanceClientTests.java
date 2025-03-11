package com.bytedata.trade;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.bytedata.trade.client.YahooFinanceClient;
import com.bytedata.trade.dto.YahooQuoteDTO;

public class YahooFinanceClientTests {
 @Test
  public void testQuoteForUSStock() throws Exception {
    YahooQuoteDTO quoteResponse =
        new YahooFinanceClient().getQuote(List.of("AAPL", "MSFT", "TSLA"));
    assertNotNull(quoteResponse.getBody().getResults().get(0));
    assertNotNull(quoteResponse.getBody().getResults().get(1));
    assertNotNull(quoteResponse.getBody().getResults().get(2));
  }

  @Test
  public void testQuoteForHKStock() throws Exception {
    YahooQuoteDTO quoteResponse = new YahooFinanceClient()
        .getQuote(List.of("0388.HK", "0005.HK", "0700.HK"));
    assertNotNull(quoteResponse.getBody().getResults().get(0));
    assertNotNull(quoteResponse.getBody().getResults().get(1));
    assertNotNull(quoteResponse.getBody().getResults().get(2));
  }
}
