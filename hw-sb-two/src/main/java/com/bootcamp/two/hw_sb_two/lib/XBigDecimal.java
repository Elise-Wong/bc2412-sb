package com.bootcamp.two.hw_sb_two.lib;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class XBigDecimal {
  //attribute
  private BigDecimal bigDecimal;
  private RoundingMode roundingMode;

  //constructor
  private XBigDecimal(Double x){ //收窄到為用Integer
    this.bigDecimal = BigDecimal.valueOf(x);
    this.roundingMode = RoundingMode.HALF_DOWN;
  }

  public static XBigDecimal valuof(Double x){
    return new XBigDecimal(x);
  }
 
  //
  public XBigDecimal divide(Double value){
    //this.bigDecimal = bigDecimal.divide(BigDecimal.valueOf(value), 2, RoundingMode.HALF_DOWN);
    this.bigDecimal = bigDecimal.divide(BigDecimal.valueOf(value), 2, this.roundingMode);
    return new XBigDecimal(bigDecimal.doubleValue());
  }

  public XBigDecimal setRoundingMode(RoundingMode roundingMode){
    this.roundingMode = roundingMode;
    return this;
  }

  public double doubleValue(){
    return this.bigDecimal.doubleValue();
  }

  public static void main(String[] args) {
    System.out.println(XBigDecimal.valuof(10.0).divide(3.0).doubleValue());
    
    System.out.println(XBigDecimal.valuof(10.0)
      .setRoundingMode(RoundingMode.CEILING).divide(3.0).doubleValue());
  }

}
