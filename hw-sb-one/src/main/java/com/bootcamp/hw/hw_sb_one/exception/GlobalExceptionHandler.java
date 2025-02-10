package com.bootcamp.hw.hw_sb_one.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.hw.hw_sb_one.model.ErrorResult;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = {ArithmeticException.class, BusinessException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public ErrorResult handleArithmetic(RuntimeException e){
    return new ErrorResult(e.getMessage());
  }
  
}
