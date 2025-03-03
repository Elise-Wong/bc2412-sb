package com.bootcamp.two.hw_sb_two.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Comments")
@Getter

public class CommentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //這不是原本的id
  private Long id;

}
