package com.tiago.gerenciador_de_plantacao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
@Entity
public class Canteiro {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double area;

    @ManyToOne @JoinColumn(name = "fk_Responsavel_Id")
    private Responsavel responsavel;
}
