package com.bootcamp.googbye.demo_sb_goodbye.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GoodByeController {
  @GetMapping(value = "/ipad/goodbye")
  public String goodbye(){
    return "Goodbye!";
  }
  
}
