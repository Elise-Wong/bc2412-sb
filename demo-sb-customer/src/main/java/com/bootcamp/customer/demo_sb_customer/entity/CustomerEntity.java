package com.bootcamp.customer.demo_sb_customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

// ! Spring: Convention Over Configuration

// ! Entity (define Table Structure by Java)
// ! mvn~ Hibernate -> rely on provided driver, generate corresponding SQL (DDL)
// ! mvn install -> test -> create table
// SQL: PK, FK, auto_increment, column name, field size

@Entity
@Table(name = "Customers")
@Getter
public class CustomerEntity {
  //PK
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment, 不斷加1
  private Long id;

  @Column(name = "customer_name") //可 加, 長度
  private String name;

  @Column(name = "customer_email")
  private String email;
  
}
