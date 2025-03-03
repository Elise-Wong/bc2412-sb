package com.bootcamp.mtr.hw_sb_mtr.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.mtr.hw_sb_mtr.service.StationService;

@Service
public class StationServiceImpl implements StationService{
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<StationDto> getStation(){
    String url = "";
    return Arrays.asList(this.restTemplate.getForObject(url, StationDto[].class));
  }

}
