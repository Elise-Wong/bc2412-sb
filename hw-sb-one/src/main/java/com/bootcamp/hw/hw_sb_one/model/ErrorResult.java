package com.bootcamp.hw.hw_sb_one.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor //for getCode
public class ErrorResult {
  private int code;
  private String message;


}
