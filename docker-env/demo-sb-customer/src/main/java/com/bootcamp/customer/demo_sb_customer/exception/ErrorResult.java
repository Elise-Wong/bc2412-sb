package com.bootcamp.customer.demo_sb_customer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class ErrorResult {
  private String code;
  private String message;


}
