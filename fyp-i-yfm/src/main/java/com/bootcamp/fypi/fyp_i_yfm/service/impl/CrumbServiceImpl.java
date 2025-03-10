package com.bootcamp.fypi.fyp_i_yfm.service.impl;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

  private static final String COOKIE = "B=12345abcde; GUC=AQEBCAFZ...";  // 你的 Cookie
  private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
  public static String CRUMBKEY;

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

    @Override
    public String getCrumbKey(){
      String url = "https://query1.finance.yahoo.com/v1/test/getcrumb";
    
      HttpHeaders headers = new HttpHeaders();
      headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
      headers.set(HttpHeaders.COOKIE, COOKIE);

      HttpEntity<String> entity = new HttpEntity<>(headers);

      ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
      CRUMBKEY = response.getBody();
      return response.getBody();
    }
    
  //
  // @Override
  // public int fetchCrumb(){
  //   int responseCode = clearCookies.getCrumb("https://query1.finance.yahoo.com/v1/test/getcrumb");
  //   System.out.println("Response Code: " + responseCode);
  //   return responseCode;
    
  // }

}
