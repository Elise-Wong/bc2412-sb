package com.bootcamp.hw.hw_sb_one.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalReqDTO {
  private String x;
  private String y;
  private String operation;
}
