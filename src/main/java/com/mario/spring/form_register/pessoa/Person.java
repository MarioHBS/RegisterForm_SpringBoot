package com.mario.spring.form_register.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "pessoa")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "nome_completo", nullable = false)
  private String name;
  @Column(name = "nascimento", nullable = false)
  private String birth;
  @Column(name = "telefone", nullable = true)
  private String number;
  @Column(name = "e_mail", nullable = false)
  private String email;

  @Column(name = "cep")
  private String adr_cep;
  @Column(name = "logradouro")
  private String adr_location;
  @Column(name = "numero")
  private int adr_numb;
  @Column(name = "bairro")
  private String adr_neighbor;
  @Column(name = "cidade")
  private String adr_city;
  @Column(name = "estado")
  private String adr_state;
}
