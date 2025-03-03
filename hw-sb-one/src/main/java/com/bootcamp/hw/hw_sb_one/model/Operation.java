package com.bootcamp.hw.hw_sb_one.model;

import com.bootcamp.hw.hw_sb_one.exception.OperationArgumentException;

public enum Operation {
  ADD, SUB, MUL, DIV,;

  //String to enum
  public static Operation of(String value){
    for(Operation o : values()){
      if (o.name().equals(value.trim().toUpperCase())){
        return o;
      }
    }
    //throw new IllegalArgumentException("No such Operation.");
    throw new OperationArgumentException();
  }
}
