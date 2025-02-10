package com.bootcamp.restful.demo_restful.service;

import java.nio.BufferOverflowException;

import org.springframework.stereotype.Service;

import com.bootcamp.restful.demo_restful.exception.BusinessException;
import com.bootcamp.restful.demo_restful.model.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalculatorService {
  public Integer operate(Operation operation, Integer x, Integer y){  //use enum to call
    int result = switch (operation){ //return switch (operation){
      case SUM -> sum(x, y);
      case SUBTRACT -> subtract(x, y);
      case MULTIPLY -> multiply(x, y);
      case DIVIDE -> divide(x, y);   // caller: divide(x, y)
    };
    System.out.println("operate(): result=" + result);
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
      // int result;
      // try {
      //   result = x / y;
      // } catch (ArithmeticException e){
      //   result = 0;
      // }
      // return result;

      //throw 是全局攔截
      System.out.println("divide()");
      if (y == 0)
        throw new BusinessException("CalculatorService.divide() / zero." 
                        + "x=" + x + ",y=" + y);
        return x / y; // when have GlobalExceptionHandler + ErrorResult
    }

  
}
