package com.tiago.gerenciador_de_plantacao.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Planta {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private Integer periodo_colheita;

    @ManyToMany(mappedBy = "plantas")
    Set<Canteiro> canteiros;

    public Planta(String nome, Integer periodo_colheita) {
        this.nome = nome; this.periodo_colheita = periodo_colheita;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPeriodo_colheita() {
        return periodo_colheita;
    }

    public void setPeriodo_colheita(Integer periodo_colheita) {
        this.periodo_colheita = periodo_colheita;
    }

    public Set<Canteiro> getCanteiros() {
        return canteiros;
    }

    public void setCanteiros(Set<Canteiro> canteiros) {
        this.canteiros = canteiros;
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Nome: " + nome +
        ", Periodo_colheita: " + periodo_colheita;
    }
}
