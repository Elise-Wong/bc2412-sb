package com.bootcamp.hw.hw_sb_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.Operation;

import com.bootcamp.hw.hw_sb_one.dto.CalReqDTO;
import com.bootcamp.hw.hw_sb_one.dto.CalRespDTO;

@SpringBootApplication
public class BcCalculatorApplication {

  @Override
  public CalRespDTO calculate1(String x, String y, String operation){
    int x1 = Integer.valueOf(x);
    Operation.of(operation)
  }

  @Override
  public CalRespDTO calculate2(String x, String y, String operation){

  }

  @Override
  public CalRespDTO calculate3(CalReqDTO calReqDTO){

  }


	private Integer calcaulte(Integer x, Integer y, Operation operation){
		return switch(operation){
			case ADD -> x + y;
			case SUB -> x - y;
			case MUL -> x * y;
			case DIV -> x / y; //TBC
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(BcCalculatorApplication.class, args);
	}

}
