package com.mario.spring.form_register.pessoa;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "pessoa")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

}
