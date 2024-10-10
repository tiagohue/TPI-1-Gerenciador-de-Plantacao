package com.tiago.gerenciador_de_plantacao.entity;

import java.sql.Date;

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
public class Plantado {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date data_plantio;

    private Date data_colheita;

    @ManyToOne @JoinColumn(name = "fk_Canteiro_Id")
    private Canteiro canteiro;
    
    @ManyToOne @JoinColumn(name = "fk_Planta_Id")
    private Planta planta;
}
