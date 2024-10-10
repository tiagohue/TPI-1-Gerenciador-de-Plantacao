package com.tiago.gerenciador_de_plantacao.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
@Entity
public class Planta {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private Integer periodo_colheita;

    @ManyToMany(mappedBy = "plantas")
    private Set<Canteiro> canteiros;
}
