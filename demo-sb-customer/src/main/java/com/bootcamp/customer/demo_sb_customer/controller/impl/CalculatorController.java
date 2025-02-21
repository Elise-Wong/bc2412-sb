package com.bootcamp.customer.demo_sb_customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.customer.demo_sb_customer.controller.CalculatorOperation;
import com.bootcamp.customer.demo_sb_customer.dto.CalculatorResult;
import com.bootcamp.customer.demo_sb_customer.service.CalculatorService;

//@Autowried(required=false) ...背後spring 已寫了
//CalculatorOperation calculatorOperation;
//then method will call calculatorOperation.xxx()

@RestController
public class CalculatorController implements CalculatorOperation{
  @Autowired
  private CalculatorService calculatorService;

  @Override
  // Unit test for calculate: assume sum() return 100 and subtract 200 -> -100
  // only focus: testing for - is work or not

  // (1, 2) -> 3-(-1) -> expect 4 is ok
  // new(1, 2) -> 3-(-2) -> expect 4 is fail
  // public int calculate(int x, int y){
  //   return sum(x, y) - subtract(x, y);
  // }
  public CalculatorResult calculate(int x, int y){
    return new CalculatorResult(calculatorService.sum(x, y) - calculatorService.subtract(x, y));
  }

  //@Override
  // Unit test for sum()
  // 1+2 -> 3
  // private int sum(int x, int y){
  //   return x + y;
  // }

  //@Override
  // Unit test for subtract()
  // 1-2 -> -1
  // private int subtract(int x, int y){
  //   return x - y;
  //   //return x - y - 1; //new ( 1-2-1 -> -2)
  // }

}
