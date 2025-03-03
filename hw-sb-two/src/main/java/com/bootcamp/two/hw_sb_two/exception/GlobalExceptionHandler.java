package com.bootcamp.two.hw_sb_two.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = UserNotFoiundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResult handleUserNotFoundException(){
    return ErrorResult.builder()
      .code(1L)
      .message("User not found.")
      .build();
  }

  @ExceptionHandler(value = NumberFormatException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResult handleNumberFormatException(){
    return ErrorResult.builder()
      .code(2L)
      .message("Invalid Input.")
      .build();
  }

  @ExceptionHandler(value = RestClientException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResult handleRestClientException(){
    return ErrorResult.builder()
      .code(3L)
      .message("RestTemplate Error - JsonPlaceHolder.")
      .build();
  }

  
}
