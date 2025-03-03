package com.bootcamp.bitcoin.demo_sb_bitcoin.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CoinDto implements Serializable{
  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty(value = "current_price")
  private Double currentPrice; // tall峰命名是OOP出身的
  @JsonProperty(value = "market_cap")
  private Long marketCap;//
  @JsonProperty(value = "market_cap_rank")
  private Long marketCapRank;
  @JsonProperty(value = "fully_diluted_valuation")
  private Long fullyDilutedValuation;
  @JsonProperty(value = "total_volume")
  private Long totalVolume;
  @JsonProperty(value = "high_24h") //有數字會hand機, 所以用呢個code
  private Double high24h;
  @JsonProperty(value = "low_24h")
  private Double low24h;
  @JsonProperty(value = "price_change_24h")
  private Double priceChange24h;
  @JsonProperty(value = "price_change_percentage_24h")
  private Double priceChangePercentage24h;
  @JsonProperty(value = "market_cap_change_24h")
  private Double marketCapChange24h;
  @JsonProperty(value = "market_cap_change_percentage_24h")
  private Double marketCapChangePercentage24h;
  @JsonProperty(value = "circulating_supply")
  private Long circulatingSupply;
  @JsonProperty(value = "total_supply")
  private Long totalSupply;
  @JsonProperty(value = "max_supply")
  private Long maxSupply;

  private Long ath;
  @JsonProperty(value =" ath_change_percentage")
  private Double athChangePercentage;
  @JsonProperty(value = "ath_date")
  private String athDate;
  
  private Double atl;
  @JsonProperty(value = "atl_change_percentage")
  private Double atlChangePercentage;
  @JsonProperty(value = "atl_date")
  private String atlDate;
  
  private Roi roi;
  @JsonProperty(value = "last_updated")
  private String lastUpdated;
  

  // Class - Roi
  @Getter
  @ToString
  public static class Roi {
    private Double times;
    private String currency;
    private Double percentage;

  }
  
  
}
