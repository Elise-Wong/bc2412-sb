package com.bootcamp.fypi.fyp_i_yfm.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.fypi.fyp_i_yfm.config.ClearCookies;
import com.bootcamp.fypi.fyp_i_yfm.model.dto.CrumbDto;
import com.bootcamp.fypi.fyp_i_yfm.service.CrumbService;



@Service
public class CrumbServiceImpl implements CrumbService{
  @Autowired
  private RestTemplate restTemplate;
  // @Autowired
  // private ClearCookies clearCookies;

  @Value("${api.yfm.url.base}")
  private String baseUrl;

  @Value("${api.yfm.url.versionC}")
  private String versionCUrl;

  @Value("${api.yfm.url.CrumbEndpoint}")
  private String getCrumbUrl;

  //
  @Override
  public CrumbDto getCrumb(){
    String url =
        UriComponentsBuilder.fromUriString(baseUrl).pathSegment(versionCUrl)
            .path(getCrumbUrl)
            .build().toUriString();

    System.out.println("url=" + url);

    return this.restTemplate.getForObject(url, CrumbDto.class);
    
  }

  //
  // @Override
  // public int fetchCrumb(){
  //   int responseCode = clearCookies.getCrumb("https://query1.finance.yahoo.com/v1/test/getcrumb");
  //   System.out.println("Response Code: " + responseCode);
  //   return responseCode;
    
  // }

}
