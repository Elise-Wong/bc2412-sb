package com.bootcamp.restful.demo_restful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.restful.demo_restful.model.ErrorResult;

@ControllerAdvice //bean
public class GlobalExceptionHandler { //全局捕捉
  @ExceptionHandler(value = {ArithmeticException.class, BusinessException.class}) //可捕捉parent , child
  @ResponseStatus(value = HttpStatus.OK) // OK=200 (well handled); bad request=400
  public ErrorResult handleArithmetic(RuntimeException e){ // either one: ArithmeticException e/ RuntimeException e
    return new ErrorResult(e.getMessage());
  }

}
