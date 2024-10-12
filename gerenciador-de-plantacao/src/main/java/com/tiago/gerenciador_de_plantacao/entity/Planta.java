package com.tiago.gerenciador_de_plantacao.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Planta {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private Integer periodo_colheita;

    @ManyToMany(mappedBy = "plantas")
    private Set<Canteiro> canteiros;

    public Planta(String nome, Integer periodo_colheita) {
        this.nome = nome; this.periodo_colheita = periodo_colheita;
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Nome: " + nome +
        ", Periodo_colheita: " + periodo_colheita;
    }
}
