package com.fyp.ii.xfin.servcie.fyp_ii_xfin.manager;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.util.Yahoo;

public class CrumbKeyManager {
  //Attribute
  private RestTemplate restTemplate;
  private CookieManager cookieManager;

  //Constructor
  public CrumbKeyManager(RestTemplate restTemplate){
    this.restTemplate = restTemplate;
    this.cookieManager = new CookieManager(restTemplate);
  }

  //Getter
  public String getCrumb(){
    try {
      String cookie = this.cookieManager.getCookie();
      HttpHeaders headers = new HttpHeaders();
      headers.add("cookie", cookie);
      HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);

      String crumbUrl = UriComponentsBuilder.newInstance()
        .scheme("https")
        .host(Yahoo.DOMAIN)
        .path(Yahoo.VERSION_CRUMB)
        .path(Yahoo.ENDPOINT_CRUMB)
        .build()
        .toUriString();

      return restTemplate
        .exchange(crumbUrl, HttpMethod.GET, entity, String.class)
        .getBody();

    } catch (RestClientException e) {
      return null;
    }
    
  
  }
  
}
