package com.tiago.gerenciador_de_plantacao.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
@Entity
@Table
public class Canteiro {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Double area;

    @ManyToOne @JoinColumn(name = "fk_Responsavel_Id")
    private Responsavel responsavel;

    @ManyToMany
    private Set<Planta> plantas;
}