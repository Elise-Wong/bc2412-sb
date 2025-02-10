package com.bootcamp.restful.demo_restful.exception;

// custom business exception
public class VincentException extends BusinessException{ //因為BusinessException 已經帶了getter, contructor, 所以這兒不用再加
  public VincentException(String message){
   super(message);
  }
}
