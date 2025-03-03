package com.bootcamp.two.hw_sb_two.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.two.hw_sb_two.entity.UserEntity;
import com.bootcamp.two.hw_sb_two.lib.XUriBuilder;
import com.bootcamp.two.hw_sb_two.model.dto.UserDto;
import com.bootcamp.two.hw_sb_two.service.UserService;

@Service
public class UserServiceImpl implements UserService{  //JPHServiceImpl
  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.users}")
  private String userEndpoint;

  @Override
  public List<UserDto> getUsers(){ //getJPHUsers, getJPHPosts, getJPHComments //如果是private, 唔洗interface
    String userUrl = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(userEndpoint)
      .build()
      .toUriString();
      
    System.out.println("url=" + userUrl);

    return Arrays.asList(this.restTemplate.getForObject(userUrl, UserDto[].class));
  }

  @Override
  public List<UserDto> getJPHUsers(){
    String url = XUriBuilder.create()
      .https()
      .host(host)
      .path(userEndpoint)
      .build();
  
}
}