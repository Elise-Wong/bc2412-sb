package com.bootcamp.customer.demo_sb_customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Addresses")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  //private Geo geo;

  @OneToOne
  @JoinColumn(name = "user_id")
  @Setter
  private UserEntity userEntity;
  
}
