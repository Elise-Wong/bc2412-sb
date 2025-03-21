package com.example.jmeter.demo_jmeter;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
  public static int availableStock = 1000;
  public static int orderCount = 0;
  public static AtomicInteger availableStock2 = new AtomicInteger(1000);
  public static AtomicInteger orderCount2 = new AtomicInteger(0);

  @GetMapping(value = "/info")
  public String getInfo(){
    return "Available Stock=" + availableStock + ", Order Count=" + orderCount;
  }

  @GetMapping(value = "/syscbuy")
  public String syscBuy() {
    if (payment2()){
      return "true, " + getInfo(); //"true, " is an object.
    }
    return "false, " + getInfo();
  }

  private synchronized boolean payment2(){ //may be service
    if (availableStock >= 1){ // 重要! 鎖!
      try{
        Thread.sleep(20); //有synchronized, runable, 就要小心點; 如果冇, 放心用single
      } catch (Exception e){
        return false;
      }
    availableStock--; // 重要! 鎖!
    orderCount++;
    return true;
    }
    return false;
  }


  @GetMapping(value = "/buy")
  public String buy(){
    //boolean result = true;

    //payment
    if (availableStock >= 1 && payment()){ //facding
      availableStock--; // 所有人都見到 1 
    // if (availableStock.get() >= 1 && payment()){ 
    //   availableStock.getAndDecrement(); 
      orderCount++;
      return "true, " + getInfo();
    }
    return "false, " + getInfo();
  }

  // payment process 20ms
  private boolean payment(){ //may be service
    try{
      Thread.sleep(20); //有synchronized, runable, 就要小心點; 如果冇, 放心用single
    } catch (Exception e){
      return false;
    }
    return true;
  }
  
}
