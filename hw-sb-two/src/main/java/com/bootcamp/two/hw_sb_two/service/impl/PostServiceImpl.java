package com.bootcamp.two.hw_sb_two.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.two.hw_sb_two.model.dto.PostDto;
import com.bootcamp.two.hw_sb_two.service.PostService;

@Service
public class PostServiceImpl implements PostService{
  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.posts}")
  private String postEndpoint;

  @Override
  public List<PostDto> getPosts(){
    String postUrl = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(postEndpoint)
      .build()
      .toUriString();

    System.out.println("url=" + postUrl);

    return Arrays.asList(this.restTemplate.getForObject(postUrl, PostDto[].class));
  }

  
}
