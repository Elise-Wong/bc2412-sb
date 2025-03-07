package com.bootcamp.customer.demo_sb_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.customer.demo_sb_customer.entity.UserEntity;
import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

  

  
}
