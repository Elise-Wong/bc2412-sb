package com.bootcamp.customer.demo_sb_customer.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootcamp.customer.demo_sb_customer.codewave.GlobalExceptionHandler;

@RestControllerAdvice //統一哂, 已經handle NPE
public class LocalExceptionHandler extends GlobalExceptionHandler{
  
}
