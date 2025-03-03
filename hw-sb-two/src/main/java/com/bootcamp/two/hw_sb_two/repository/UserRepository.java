package com.bootcamp.two.hw_sb_two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.two.hw_sb_two.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


  
}
