package com.bootcamp.swagger.demo_swagger.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StockDTO {
  private String symbol;
  private String description;
  
}
