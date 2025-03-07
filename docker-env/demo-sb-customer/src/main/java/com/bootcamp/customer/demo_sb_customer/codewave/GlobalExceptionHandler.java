package com.bootcamp.customer.demo_sb_customer.codewave;

import org.springframework.web.bind.annotation.ExceptionHandler;


// 先統一, 後抽離

//@RestControllerAdvice //冇左這個是死物
public class GlobalExceptionHandler {
  @ExceptionHandler(BusinessException.class)
  //public ErrorResult handleBusinessException(BusinessException e){
  //  return new ErrorResult(e.getCode(), e.getMessage()); //JSON
  public ApiResp<Void> handleBusinessException(BusinessException e){ //null is satus; void係冇野
    return ApiResp.<Void>builder()
      //.code(e.getCode())
      //.message(e.getMessage())
      .syscode(e.getSysCode())
      .build(); //.data(null) is exised, so no need further to write.
  }

  @ExceptionHandler(NullPointerException.class)
  public ApiResp<Void> handleNullPointerException(){
    return ApiResp.<Void>builder()
      .syscode(SysCode.RTE_NPE)
      .build();
  }

    
    
  
}
