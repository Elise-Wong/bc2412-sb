package com.bootcamp.customer.demo_sb_customer.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConfig {

  //可以每晚收市run
  ///@Scheduled(cron = "0 40 17 * * MON")
  public void testCronJob(){
    System.out.println("Test cron job");
  }

  //每3S出Hello World!
  //wait: 8000ms
  ///@Scheduled(fixedDelay = 3000) // 3000ms=3s
  public void sayHello() throws Exception{
    System.out.println(System.currentTimeMillis());
    Thread.sleep(5000); // wait: 相差3000+5000=8000
    System.out.println("Hello World!");
  }

  //wait: 2000ms
  ///@Scheduled(fixedDelay = 2000) //這是2支flag
  public void sayGoodBye(){
    System.out.println("GoodBye!");
  }

  //盡快行用這個
  //wait : 5000ms
  ///@Scheduled(fixedRate = 4000)
  public void sayBye() throws Exception{
    System.out.println(System.currentTimeMillis()); //in & out from 1970年後計
    Thread.sleep(5000);//task 的長度比等待的長度長, 所以跟task長度
    System.out.println("ABCD!");
  }


  
}
