package com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class YahooQuoteErrorDTO {
  @JsonProperty("finance")
  private QuoteDTO.QuoteBody body;
  
}
