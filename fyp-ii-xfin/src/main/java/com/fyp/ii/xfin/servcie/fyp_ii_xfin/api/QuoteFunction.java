package com.fyp.ii.xfin.servcie.fyp_ii_xfin.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.QuoteDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto.YahooQuoteErrorDTO;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.exception.StockQuoteYahooException;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.util.Yahoo;

public interface QuoteFunction {
  RestTemplate getRestTemplate();

  String getCrumbKey();

  // https://query1.finance.yahoo.com/v7/finance/quote?symbols=MSFT,AAPL&crumb=wH.alLk3BaV
  default QuoteDTO getQuote(List<String> symbols)
      throws JsonProcessingException {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.put("symbols", List.of(String.join(",", symbols)));

    String crumbKey = this.getCrumbKey();
    params.put("crumb", List.of(crumbKey));

    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(Yahoo.DOMAIN) //
        .path(Yahoo.VERSION_QUOTE) //
        .path(Yahoo.ENDPOINT_QUOTE) //
        .queryParams(params) //
        .toUriString();

    ResponseEntity<String> response =
        this.getRestTemplate().getForEntity(url, String.class);
    if (!response.getStatusCode().equals(HttpStatus.OK)) {
      YahooQuoteErrorDTO errorDto = new ObjectMapper()
          .readValue(response.getBody(), YahooQuoteErrorDTO.class);
      throw new StockQuoteYahooException(errorDto);
    }
    QuoteDTO quoteDTO =
        new ObjectMapper().readValue(response.getBody(), QuoteDTO.class);
    System.out.println(quoteDTO);
    return quoteDTO;
  }
}
