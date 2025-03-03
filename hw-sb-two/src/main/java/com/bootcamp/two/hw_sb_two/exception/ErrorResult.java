package com.bootcamp.two.hw_sb_two.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorResult {
  private Long code;
  private String message;
}
