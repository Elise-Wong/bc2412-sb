package com.bootcamp.fypi.fyp_i_yfm.config;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClearCookies {
  private static final String COOKIE = "B=12345abcde; GUC=AQEBCAFZ...";  // 你的 Cookie
  private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

  private RestTemplate restTemplate;


  public int getCrumb(String urlString) {
      try {
          // Create URL object
          URL url = new URL(urlString);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();

          // 设置 User-Agent
          // List<String> userAgents = Arrays.asList(
          //   "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36",
          //   "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36",
          //   "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
          //   "Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.1 Mobile/15E148 Safari/604.1"
          //   // Add more user agents
          // );
          // Set header
          //connection.setRequestProperty("User-Agent", userAgents);
          connection.setRequestProperty("User-Agent", USER_AGENT);
          
          // Clear cookies
          //connection.setRequestProperty("Cookie", "");  // Clear cookies

          // Clear cookie 的 header
          //connection.setRequestProperty("Cookie", "sessionId=; Max-Age=0; Path=/");
          connection.setRequestProperty("Cookie", COOKIE);
          
          // Set request method
          connection.setRequestMethod("GET");
          connection.setDoOutput(true);

          // Send request and get response code
          return connection.getResponseCode();
            
      } catch (Exception e) {
           e.printStackTrace();
          return -1; // Return -1 to indicate an error
      }
  }
  
}
