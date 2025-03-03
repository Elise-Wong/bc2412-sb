package com.bootcamp.hw.hw_sb_one.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.hw.hw_sb_one.controller.BcCalculatorOperation;
import com.bootcamp.hw.hw_sb_one.dto.CalReqDTO;
import com.bootcamp.hw.hw_sb_one.dto.CalRespDTO;
import com.bootcamp.hw.hw_sb_one.service.BcCalculatorService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(value = "/ex1")
public class BcCalculatorController implements BcCalculatorOperation{
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
  
  @Override
  public CalRespDTO calculate1(String x, String y, String operation){
    Double param1 = Double.valueOf(x);
    Double param2 = Double.valueOf(y);
    Operation operator = Operation.of(operation);
    Double result = calcaulte(param1, param2, operator, result)
    return this.mapper.map(x, y, operator, result);
  }

  @Override
  public CalRespDTO calculate2(String x, String y, String operation){
    Double param1 = Double.valueOf(x);
    Double param2 = Double.valueOf(y);
    Operation operator = Operation.of(operation);
    Double result = calcaulte(param1, param2, operator, result)
    return this.mapper.map(x, y, operator, result);
  }

  @Override
  public CalRespDTO calculate3(CalReqDTO calReqDTO){
    Integer param1 = Integer.valueOf(reqDTO.getX());
    Integer param2 = Integer.valueOf(reqDTO.getY());
    Operation operator = Operation.of(reqDTO.getOperation());
    Integer result = calcaulte(param1, param2, operator, result)
    return this.mapper.map(x, y, operator, result);
  }

  private Integer calcaulte(Double x, Double y, Operation operation){
		return switch(operation){
			case ADD -> x + y;
			case SUB -> x - y;
			case MUL -> x * y;
			//case DIV -> x / y; //TBC
      case DIV -> BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y), RoundingMode.HALF_DOWN).doubleValue();
		};
	}

  public static void main(String[] args) {
    double result = BigDecimal.valueOf(10.0).divide(BigDecimal.valueOf(3.0), RoundingMode.HALF_DOWN)
    .doubleValue();
    System.out.println(result);

  }
  
}
