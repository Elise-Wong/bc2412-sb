package com.bootcamp.swagger.demo_swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.swagger.demo_swagger.entity.StockEntity;

//@Repository //spring boot 3 , no need add @Repository
public interface StockRepository extends JpaRepository<StockEntity, String>{ //PK change to String


  
}
