package com.bootcamp.two.hw_sb_two.lib;

import org.springframework.web.util.UriComponentsBuilder;

// for service get url
public class XUriBuilder {
  //attribute
  private UriComponentsBuilder uriComponentsBuilder;
  private String scheme;
  private String host;
  private String path;

  //封裝
  public static XUriBuilder create(){ //newINstance()
    return new XUriBuilder();
  }

  //constructor
  public XUriBuilder(){
    this.uriComponentsBuilder = UriComponentsBuilder.newInstance();

  }

  public XUriBuilder https(){
    this.scheme = "https";
    return this;
  }

  public XUriBuilder http(){
    this.scheme = "http";
    return this;
  }

  public XUriBuilder host(String host){
    this.host = host;
    return this;
  }

  public XUriBuilder path(String path){
    this.path = path;
    return this;
  }

  public String build(){
    return this.uriComponentsBuilder
      .scheme(this.scheme).host(this.host).path(this.path).toUriString();
  }


}
