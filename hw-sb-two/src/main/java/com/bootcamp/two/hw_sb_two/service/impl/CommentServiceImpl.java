package com.bootcamp.two.hw_sb_two.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.two.hw_sb_two.model.dto.CommentDto;
import com.bootcamp.two.hw_sb_two.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.comments}")
  private String commentEndpoint;

  @Override
  public List<CommentDto> getComments(){
    String commentUrl = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(commentEndpoint)
      .build()
      .toUriString();

    System.out.println("url=" + commentUrl);

    return Arrays.asList(this.restTemplate.getForObject(commentUrl, CommentDto[].class));
  }

  // List<CommentDto> postComments = 
  // filtered commentDtos = commentDtos
  // .stream
  // .filter(e -> e.getPostId() == postId)
  // .collect(Collectors.toList());

}
