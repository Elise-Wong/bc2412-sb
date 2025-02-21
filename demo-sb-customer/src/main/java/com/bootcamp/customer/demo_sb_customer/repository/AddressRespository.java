package com.bootcamp.customer.demo_sb_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.customer.demo_sb_customer.entity.AddressEntity;

@Repository
public interface AddressRespository extends JpaRepository<AddressEntity, Long>{


  
}
