package com.bootcamp.swagger.demo_swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.bootcamp.swagger.demo_swagger.dto.mapper.DTOMapper;
import com.bootcamp.swagger.demo_swagger.entity.mapper.EntityMapper;

@Configuration
public class AppConfig {
  // @Component = @Bean, 即係有左Component, 就不需要加Bean

  // @Bean
  // DTOMapper dtoMapper{
  //   return new DTOMapper();
  // }

  // @Bean
  // EntityMapper entityMapper(){
  //   return new EntityMapper();
  // }

  
}
