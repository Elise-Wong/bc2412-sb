package com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.TransactionEntity;

import io.lettuce.core.dynamic.annotation.Param;

@Repository //ans: task 5
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

  @Query(value = 
    "SELECT p FROM TransactionEntity p WHERE p.symbol = :symbol AND p.marketUnixTime BETWEEN :startEpoch AND :endEpoch"
    , nativeQuery = false)
  List<TransactionEntity> findBySymbol(String symbol, long startEpoch, long endEpoch);

  @Query(value = 
    "SELECT max(p.marketUnixTime) FROM TransactionEntity p WHERE p.symbol = :symbol"
    , nativeQuery = true)
  Long getMaxMarketTime(@Param("symbol") String symbol);

}
