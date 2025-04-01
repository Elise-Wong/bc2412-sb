package com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class QuoteDto implements Serializable{
  @JsonProperty("quoteResponse")
  private QuoteResponse quoteResponse; //

  //class - QuoteResponse
  @Getter
  @Setter
  @Builder
  @ToString
  public static class QuoteResponse {
    private Result[] result;
    private String error; // Using String for simplicity, could be null


  //class - result
  @Getter
  @Setter
  @Builder
  @ToString
  public static class Result {
    private String language;
    private String region;
    private String quoteType;
    private String typeDisp;
    private String quoteSourceName;
    private boolean triggerable;
    private String customPriceAlertConfidence;
    private String regularMarketChangePercent;
    private Double regularMarketPrice;
    private String currency;
    private CorporateAction[] corporateActions; //
    private long regularMarketTime;
    private String exchange;
    private String messageBoardId;
    private String exchangeTimezoneName;
    private String exchangeTimezoneShortName;
    private String gmtOffSetMilliseconds;
    private String market;
    private boolean esgPopulated;
    private String marketState;
    private String shortName;
    private String longName;
    private boolean hasPrePostMarketData;
    private String firstTradeDateMilliseconds;
    private String priceHint;
    private String regularMarketChange;
    private Double regularMarketDayHigh;
    private String regularMarketDayRange;
    private Double regularMarketDayLow;
    private Long regularMarketVolume;
    private String regularMarketPreviousClose;
    private Double bid;
    private Double ask;
    private int bidSize;
    private int askSize;
    private String fullExchangeName;
    private String financialCurrency;
    private Double regularMarketOpen;
    private Long averageDailyVolume3Month;
    private Double averageDailyVolume10Day;
    private Double fiftyTwoWeekLowChange;
    private Double fiftyTwoWeekLowChangePercent;
    private String fiftyTwoWeekRange;
    private Double fiftyTwoWeekHighChange;
    private Double fiftyTwoWeekHighChangePercent;
    private Double fiftyTwoWeekLow;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekChangePercent;
    private long earningsTimestampStart;
    private long earningsTimestampEnd;
    private Double trailingAnnualDividendRate;
    private Long sharesOutstanding;
    private Double bookValue;
    private Double fiftyDayAverage;
    private Double fiftyDayAverageChange;
    private Double fiftyDayAverageChangePercent;
    private Double twoHundredDayAverage;
    private Double twoHundredDayAverageChange;
    private Double twoHundredDayAverageChangePercent;
    private String marketCap;
    private Double priceToBook;
    private Long sourceInterval;
    private Long exchangeDataDelayedBy;
    private Double epsTrailingTwelveMonths;
    private boolean tradeable;
    private boolean cryptoTradeable;
    private String symbol;
    
  }

    //class - CorporateAction
    @Getter
    @Setter
    @Builder
    @ToString
    public static class CorporateAction {
      private String header;
      private String message;
      private Meta meta; //

      // class - Meta
      @Getter
      @Setter
      @Builder
      @ToString
      public static class Meta{
        private String eventType;
        private long dateEpochMs;
        private Double amount;
      }
    }
  }
}  