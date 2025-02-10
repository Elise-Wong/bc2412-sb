package com.bootcamp.restful.demo_restful.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.restful.demo_restful.DemoSbRestfulApplication;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BeanController {
  @GetMapping(value = "/beans")
  public List<String> getBeans() {
      return Arrays.asList(DemoSbRestfulApplication.context.getBeanDefinitionNames());
  }
  
  
}
