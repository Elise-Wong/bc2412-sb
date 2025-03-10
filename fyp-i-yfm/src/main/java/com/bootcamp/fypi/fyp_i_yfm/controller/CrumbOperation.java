package com.bootcamp.fypi.fyp_i_yfm.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.fypi.fyp_i_yfm.model.dto.CrumbDto;

public interface CrumbOperation {
  @GetMapping(value = "/crumb")
  public CrumbDto getCrumb();

  @GetMapping(value = "/crumbKey")
  public String getCrumbKey();
  
}
