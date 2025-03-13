package com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Quote")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //這不是原本的id
  private Long id;
}
