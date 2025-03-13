package com.fyp.ii.xfin.servcie.fyp_ii_xfin.manager;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.api.QuoteFunction;

public class YFinanceManager implements QuoteFunction{
  private static final String USER_AGENT_STRING = "Mozilla/5.0"; //only this is hard code.

  private RestTemplate restTemplate;
  private CrumbKeyManager crumbKeyManager;

  public YFinanceManager() {
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new UserAgentInterceptor(USER_AGENT_STRING));

    // Set Connection and Read Timeout.
    this.restTemplate = new RestTemplateBuilder() //
        .connectTimeout(Duration.ofSeconds(5)) //
        .readTimeout(Duration.ofSeconds(5)) //
        .build();

    // for user-agent
    this.restTemplate.setInterceptors(interceptors);
    this.crumbKeyManager = new CrumbKeyManager(this.restTemplate); // ! share the same object of RestTemplate, not ser for real time
  } //share cookies~

  @Override
  public RestTemplate getRestTemplate() {
    return this.restTemplate;
  }

  @Override
  public String getCrumbKey() {
    return this.crumbKeyManager.getCrumb();
  }

  private static class UserAgentInterceptor
      implements ClientHttpRequestInterceptor {
    private final String userAgent;

    public UserAgentInterceptor(String userAgent) {
      this.userAgent = userAgent;
    }

    @Override
    public @NonNull ClientHttpResponse intercept(@NonNull HttpRequest request,
        @NonNull byte[] body, @NonNull ClientHttpRequestExecution execution)
        throws IOException {
      request.getHeaders().set("User-Agent", userAgent);
      return execution.execute(request, body);
    }
  }
}
