package com.fyp.ii.xfin.servcie.fyp_ii_xfin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO {
  @JsonProperty("quoteResponse")
  private QuoteBody body;

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class QuoteBody {
    @JsonProperty("result")
    private List<Result> results;
    private QuoteError error;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
    private String symbol;
    private long regularMarketTime;
    private Double regularMarketPrice;
    private String regularMarketChange;
    private Double regularMarketChangePercent;
    private Double bid;
    private Double ask;
    }

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class QuoteError {
    private String code;
    private String message;
  }
}
}
