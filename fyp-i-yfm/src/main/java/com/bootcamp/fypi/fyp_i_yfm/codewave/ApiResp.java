package com.bootcamp.fypi.fyp_i_yfm.codewave;

public class ApiResp<T> {
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

    public Builder<T> data(T data){
      this.data = data;
      return this;
    }

    public ApiResp<T> build(){
      return new ApiResp<>(this);
    }

  }
  
}
