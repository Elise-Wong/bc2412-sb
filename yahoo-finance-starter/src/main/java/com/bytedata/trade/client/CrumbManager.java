package com.bytedata.trade.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bytedata.trade.util.Yahoo;

public class CrumbManager {
  private RestTemplate restTemplate;
  private CookieManager cookieManager;

  public CrumbManager(RestTemplate restTemplate) { //(CookieManager cookieManager)...但封裝得好差, 唔夠簡約
    this.restTemplate = restTemplate;
    this.cookieManager = new CookieManager(restTemplate); // = cookieManager
  }

  public String getCrumb() {
    try {
      String cookie = this.cookieManager.getCookie();
      // System.out.println("cookie=" + cookie);
      HttpHeaders headers = new HttpHeaders();
      headers.add("Cookie", cookie);
      HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);

      String crumbUrl = UriComponentsBuilder.newInstance()
          .scheme("https") //
          .host(Yahoo.DOMAIN) //
          .path(Yahoo.VERSION_CRUMB) //
          .path(Yahoo.ENDPOINT_CRUMB) //
          .toUriString();
      // System.out.println("crumb url=" + crumbUrl);
      return restTemplate
          .exchange(crumbUrl, HttpMethod.GET, entity, String.class) //
          .getBody();
    } catch (RestClientException e) {
      return null;
    }
  }
}
