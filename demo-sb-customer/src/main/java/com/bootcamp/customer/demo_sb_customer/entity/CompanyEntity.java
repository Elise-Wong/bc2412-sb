package com.bootcamp.customer.demo_sb_customer.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Company")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder //for mock test
@EqualsAndHashCode //for mock test
public class CompanyEntity { //implements Serializable...加左冇死. (Java同database commnication, 因為是2種語言)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "company_name")
  private String name;
  private String catchPhrase;
  private String bs;

  @OneToOne
  @JoinColumn(name = "user_id")
  @Setter
  private UserEntity userEntity;
  
}
