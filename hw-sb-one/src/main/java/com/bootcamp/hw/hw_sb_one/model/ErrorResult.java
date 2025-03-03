package com.bootcamp.hw.hw_sb_one.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResult {
  private String code;
  private String message;
}
