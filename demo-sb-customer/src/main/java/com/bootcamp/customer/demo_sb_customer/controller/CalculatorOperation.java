package com.bootcamp.customer.demo_sb_customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bootcamp.customer.demo_sb_customer.dto.CalculatorResult;

public interface CalculatorOperation {
  @GetMapping(value = "/calculate/{x}/{y}")
  public CalculatorResult calculate(@PathVariable int x, @PathVariable int y);


  //private int sum(int x, int y);


  //private int subtract(int x, int y);
}
