package com.bootcamp.hw.hw_sb_one.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.hw.hw_sb_one.service.BcCalculatorService;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(value = "/ex1")
public class BcCalculatorController {
  //http://localhost:8082/ex1/operation/SUM?x=1&y=2&operation=

  @Autowired
  private BcCalculatorService bcCalculatorService;

  @GetMapping(value = "/operation/{operation}")
  @ResponseStatus(value = HttpStatus.OK)
  public String operate(@PathVariable Operation operation,
    @RequestParam Integer x, @RequestParam Integer y, @RequestParam String method) {
      return switch (operation){
        case "add" -> BigDecimal.valueOf(x).add(BigDecimal.valueOf(y)).doubleValue();
      }

      //toString()
  }
  
  
}
