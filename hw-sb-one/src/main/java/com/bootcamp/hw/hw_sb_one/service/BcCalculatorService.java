package com.bootcamp.hw.hw_sb_one.service;

import org.springframework.stereotype.Service;

import com.bootcamp.hw.hw_sb_one.exception.BusinessException;

@Service
public class BcCalculatorService {
  public Integer operate(Operation operation, Integer x, Integer y, String method){
    int result = operation;

    return result;
  }

  public Integer sum(Integer x, Integer y){
    return x + y;
  }

  public Integer subtract(Integer x, Integer y){
    return x - y;
  }

  public Integer multiply(Integer x, Integer y){
    return x * y;
  }

  public Integer divide(Integer x, Integer y){
    if (y == 0){
      throw new BusinessException("BcCalculatorService.divide()"
          + x + y);
      return x / y;
    }
  }
  
}
