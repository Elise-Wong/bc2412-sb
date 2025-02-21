package com.bootcamp.customer.demo_sb_customer.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Autowired(required=false)
//CommandLineRunner commandLineRunner;
//instance method -> commandLineRunner.run();

@Component //bean
public class PreServerStartConfig implements CommandLineRunner {
  //compairable 
  @Override
  public void run(String... args) throws Exception{ //from CommandLineRunner
    // hw-sb-ex3
    // call JPH users, post, comment api
    // save DB
    System.out.println("Hello!!!!!!");

    int x = 3;
    if (x < 4){
      throw new Exception();
    }
    
  }


}
