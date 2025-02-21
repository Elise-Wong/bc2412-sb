package com.bootcamp.customer.demo_sb_customer.entity.mapper;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.bootcamp.customer.demo_sb_customer.dto.UserDTO;
import com.bootcamp.customer.demo_sb_customer.entity.AddressEntity;
import com.bootcamp.customer.demo_sb_customer.entity.CompanyEntity;
import com.bootcamp.customer.demo_sb_customer.entity.GeoEntity;
import com.bootcamp.customer.demo_sb_customer.entity.UserEntity;
import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Component
public class EntityMapper {
  public UserEntity map(UserDto dto){
    return UserEntity.builder()
      .email(dto.getEmail())
      .name(dto.getName())
      .username(dto.getUsername())
      .phone(dto.getPhone())
      .website(dto.getWebsite())
      .build();
  }

  public AddressEntity map(UserDto.Address address){
    return AddressEntity.builder()
      .street(address.getStreet())
      .suite(address.getSuite())
      .city(address.getCity())
      .zipcode(address.getZipcode())
      .build();
  }

  public CompanyEntity map(UserDto.Company company){
    return CompanyEntity.builder()
      .name(company.getName())
      .catchPhrase(company.getCatchPhrase())
      .bs(company.getBs())
      .build();
  }

  public GeoEntity map(UserDto.Address.Geo geo){
    return GeoEntity.builder()
      .latitude(Double.valueOf(geo.getLatitude()))
      .longitude(Double.valueOf(geo.getLongitude()))
      .build();
  }
}
