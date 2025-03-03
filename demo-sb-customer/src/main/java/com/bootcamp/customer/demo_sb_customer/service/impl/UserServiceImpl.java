package com.bootcamp.customer.demo_sb_customer.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.customer.demo_sb_customer.codewave.RedisManager;
import com.bootcamp.customer.demo_sb_customer.entity.AddressEntity;
import com.bootcamp.customer.demo_sb_customer.entity.CompanyEntity;
import com.bootcamp.customer.demo_sb_customer.entity.GeoEntity;
import com.bootcamp.customer.demo_sb_customer.entity.UserEntity;
import com.bootcamp.customer.demo_sb_customer.entity.mapper.EntityMapper;
import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;
import com.bootcamp.customer.demo_sb_customer.repository.AddressRespository;
import com.bootcamp.customer.demo_sb_customer.repository.CompanyRepository;
import com.bootcamp.customer.demo_sb_customer.repository.GeoRespository;
import com.bootcamp.customer.demo_sb_customer.repository.UserRepository;
import com.bootcamp.customer.demo_sb_customer.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService{
  @Autowired //在內容read
  private RestTemplate restTemplate;
  @Autowired
  private EntityMapper entityMapper;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AddressRespository addressRespository;
  @Autowired
  private GeoRespository geoRespository;
  @Autowired
  private CompanyRepository companyRepository;
  
  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  //after hv library
  @Autowired
  private RedisManager redisManager;

      // fack url
      //https://jsonplaceholder.typicode.com/users 

  @Value("${api.jsonplaceholder.domain}") //在   read
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.users}")
  private String userEndpoint;
  
    @Override
    public List<UserDto> getUser() throws JsonProcessingException{ //List 好難用declolisation
    //Step 1: Red Redis first, if found, return users
    // [{}, {}, {}] to database
    //String json = this.redisTemplate.opsForValue().get("jph-users");
    
    UserDto[] redisData = this.redisManager.get("jph-users", UserDto[].class);

    // [{}, {}, {}] -> Java Object (Deserialization)
    //ObjectMapper objectMapper = new ObjectMapper();
    //if (json != null){
      //UserDto[] userDtos = objectMapper.readValue(json, UserDto[].class);
      //return Arrays.asList(userDtos);
      if (redisData != null){
        return Arrays.asList(redisData);
   }


      //Step 2: if not found, call JPM

      //String url = "https://jsonplaceholder.typicode.com/users";
      String url = UriComponentsBuilder.newInstance()
        .scheme("https")
        .host(domain)
        .path(userEndpoint)
        .build()
        .toUriString();//
      System.out.println("url=" + url);
      // return Arrays.asList(this.restTemplate.getForObject(url, UserDto[].class)); //get for object
      List<UserDto> userDtos = Arrays.asList(this.restTemplate.getForObject(url, UserDto[].class));
      
      // Save User List to DB
      // Entity, Repository
      // 1 map mapping, 3 tables
      // user, address (user_id), Geo (address_id), Company (user_id)

      // Clear DB : 由小至大
      this.geoRespository.deleteAll();  // 因為佢係void, 所以唔洗test
      this.addressRespository.deleteAll();
      this.companyRepository.deleteAll();
      this.userRepository.deleteAll(); //因為有hibunate 有delete * from


      // Save DB (procedures)
      userDtos.stream().forEach(e -> {
        UserEntity userEntity = this.userRepository.save(this.entityMapper.map(e));

      AddressEntity addressEntity = this.entityMapper.map(e.getAddress());
      addressEntity.setUserEntity(userEntity);
      this.addressRespository.save(addressEntity);
      GeoEntity geoEntity = this.entityMapper.map(e.getAddress().getGeo());
      geoEntity.setAddressEntity(addressEntity);
      this.geoRespository.save(geoEntity);

      CompanyEntity companyEntity = this.entityMapper.map(e.getCompany());
      companyEntity.setUserEntity(userEntity);
      this.companyRepository.save(companyEntity);
    });

    //Step 3: Write the users back to redis
    //Java Object -> "[{},{},{}]" (Serialization)
    //String serializedJson = objectMapper.writeValueAsString(userDtos);
    //this.redisTemplate.opsForValue().set("jph-users", serializedJson, Duration.ofMinutes(1)); // 1 min內不會消失
    
    this.redisManager.set("jph-users", userDtos, Duration.ofMinutes(1));
    
    return userDtos;
  }








  

}
