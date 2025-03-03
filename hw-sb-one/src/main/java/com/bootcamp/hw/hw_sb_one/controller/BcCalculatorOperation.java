package com.bootcamp.hw.hw_sb_one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.hw.hw_sb_one.dto.CalReqDTO;
import com.bootcamp.hw.hw_sb_one.dto.CalRespDTO;

import jakarta.websocket.server.PathParam;

public interface BcCalculatorOperation {
  @GetMapping(value = "/operation")
  CalRespDTO calculate1(@RequestParam String x, @RequestParam String y, @RequestParam String operation);

  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  CalRespDTO calculate2(@PathVariable String x, @PathVariable String y, @PathVariable String operation);

  @PostMapping(value = "/operation")
  CalRespDTO calculate3(@RequestBody CalReqDTO calReqDTO);


}
