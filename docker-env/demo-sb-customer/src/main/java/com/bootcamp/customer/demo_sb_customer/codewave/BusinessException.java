package com.bootcamp.customer.demo_sb_customer.codewave;

import java.time.LocalDate;

public class BusinessException extends RuntimeException{
  //private String code; //parent class doesnt hv it
  private SysCode syscode;


  public static BusinessException of(SysCode sysCode){
    return new BusinessException(sysCode);
  }

  // public BusinessException(String code, String message){
    // super(message);
  public BusinessException(SysCode sysCode){ 
    super(sysCode.getMessage());
    //this.code = sysCode.getCode();
    this.syscode = sysCode;
  }


  public SysCode getSysCode(){
    return this.syscode;
  }



  public static void main(String[] args) {
    LocalDate.of(2024,4,4);
  }
  
}
