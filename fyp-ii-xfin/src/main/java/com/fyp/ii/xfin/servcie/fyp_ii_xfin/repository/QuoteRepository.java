package com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.QuoteEntity;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Long>{
  
}
