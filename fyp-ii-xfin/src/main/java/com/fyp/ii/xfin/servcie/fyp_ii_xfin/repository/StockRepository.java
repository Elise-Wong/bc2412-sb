package com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> { //task 2

  //task 3b by gpt
  //List<String> findAllStockSymbols(); // get data from database(pgAdmin)

  Optional<StockEntity> findBySymbol(String symbol);
  

  
}
