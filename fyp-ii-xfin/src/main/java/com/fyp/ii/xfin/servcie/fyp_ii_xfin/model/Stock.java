package com.fyp.ii.xfin.servcie.fyp_ii_xfin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
  private Long id;
  private String symbol;
  
}
