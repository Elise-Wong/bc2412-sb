package com.bootcamp.swagger.demo_swagger.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tstocks") //t = table
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity implements Serializable{
  @Id
  private Long id; //冇左平時果句
  private String symbol; //find by id = find by symbol
  @Setter
  private String description;
  
}
