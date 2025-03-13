package com.fyp.ii.xfin.servcie.fyp_ii_xfin.exception;

public enum YahooFinanceError implements Errorable {
  Entity_NOT_FOUND_EX(1, "Entity not found."), //
  INV_INPUT_EX(2, "Invalid Input."), //
  REST_CLIENT_EX(3, "Rest Client Exception."),;

  private int code;
  private String message;

  private YahooFinanceError(int code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public int getCode() {
    return this.code;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
