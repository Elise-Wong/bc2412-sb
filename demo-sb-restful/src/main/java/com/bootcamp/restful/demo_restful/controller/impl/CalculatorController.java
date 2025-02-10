package com.bootcamp.restful.demo_restful.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.restful.demo_restful.model.Operation;
import com.bootcamp.restful.demo_restful.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController // ! return to JSON: @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/v1")  //(value = "/api/v1")
public class CalculatorController {
  // URL
  // http://localhost:8082/v1/operation/SUM?x=1&y=2
  
  // sum: 1+2 , return 3
  // subtract: 1-2, return -1
  // multiply: 1*2, return 2
  // divide: 9/3, return 3
  // @GetMapping(value = "/operation/{operation}")
  // public Integer operate(@PathVariable Operation operation, 
  //     @RequestParam Integer x, @RequestParam Integer y){  //use enum to call
  //   return switch (operation){
  //     case SUM -> x + y;
  //     case SUBTRACT -> x - y;
  //     case MULTIPLY -> x * y;
  //     case DIVIDE -> { 
  //       // int result = y == 0 ? 0 : x / y; //cant use if, and this can only be used once
  //       // yield result;
  //       int result;
  //       try {
  //         result = x / y;
  //       } catch (ArithmeticException e){
  //         result = 0;
  //       }
  //       yield result;
  //     }
  //   };
  // }

  @Autowired //included constructor
  private CalculatorService calculatorService;

  @GetMapping(value = "/operation/{operation}")
  @ResponseStatus(value = HttpStatus.OK)
  public Integer operate(@PathVariable Operation operation, 
    @RequestParam Integer x, @RequestParam Integer y) {
      return this.calculatorService.operate(operation, x, y);

  }
  

  
  
}
