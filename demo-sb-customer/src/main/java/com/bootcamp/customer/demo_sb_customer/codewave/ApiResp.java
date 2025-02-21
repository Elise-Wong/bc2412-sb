package com.bootcamp.customer.demo_sb_customer.codewave;

import java.lang.module.ModuleDescriptor.Builder;

import lombok.ToString;

// ! 因為share all user, no lombok (@Getter, @Setter)
// 不限制於mvn, spring boot
// 可抽離

//@ToString //for test/read in mvn
public class ApiResp<T> { //Resp: Response
  private String code;
  private String message;
  private T data;

  public static <T> Builder<T> builder(){
    return new Builder<>();
  }

  // for customerCotrollerTest
  public ApiResp() {
    
  }

  //constructor - 左手交右手
  public ApiResp(Builder<T> builder){
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  //Getter
  public String getCode(){
    return this.code;
  }

  public String getMessage(){
    return this.message;
  }

  public T getData(){
    return this.data;
  }

  // Builder
  public static class Builder<T>{ // this <T> not same as ApiResp<T>
    private String code;
    private String message;
    private T data;

    // 代替以下那2個
    public Builder<T> syscode(SysCode sysCode){
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      return this;
    }

    //public Builder<T> code(String code){
    //  this.code = code;
    //  return this;
    //}

    //public Builder<T> message(String message){
    //  this.message = message;
    //  return this;
    //}

    public Builder<T> data(T data){
      this.data = data;
      return this;
    }

    public ApiResp<T> build(){
      return new ApiResp<>(this);
    }

  }
  
}
