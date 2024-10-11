package com.tiago.gerenciador_de_plantacao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Responsavel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
}
