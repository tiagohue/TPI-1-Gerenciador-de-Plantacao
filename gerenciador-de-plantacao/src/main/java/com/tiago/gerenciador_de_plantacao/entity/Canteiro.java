package com.tiago.gerenciador_de_plantacao.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table
public class Canteiro {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Double area;

    @ManyToOne @JoinColumn(name = "fk_Responsavel_Id")
    private Responsavel responsavel;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Plantada", 
        joinColumns = @JoinColumn(name = "canteiro_id"), 
        inverseJoinColumns = @JoinColumn(name = "planta_id")
    )
    Set<Planta> plantas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Aplicado", 
        joinColumns = @JoinColumn(name = "canteiro_id"), 
        inverseJoinColumns = @JoinColumn(name = "insumo_id")
    )
    Set<Insumo> insumos;

    public Canteiro(Double area, Responsavel responsavel) {
        this.area = area; this.responsavel = responsavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Set<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(Set<Planta> plantas) {
        this.plantas = plantas;
    }

    public Set<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(Set<Insumo> insumos) {
        this.insumos = insumos;
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Area: " + area +
        ", Responsavel: " + responsavel +
        ", Plantas: " + plantas +
        ", Insumos: " + insumos;
    }


}
