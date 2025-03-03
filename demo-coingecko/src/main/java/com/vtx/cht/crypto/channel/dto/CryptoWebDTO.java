package com.vtx.cht.crypto.channel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class CryptoWebDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Double marketCap;
  private Double totalVolume; //
  private Double priceChange24h;
  private Double priceChangePercentage24h;
  //@JsonFormat()
  private String lastUpdated;
}
