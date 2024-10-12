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
public class Insumo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    @ManyToMany(mappedBy = "insumos")
    private Set<Canteiro> canteiros;

    @Override
    public String toString() {
        return "Id: " + id +
        ", Descricao: " + descricao;
    }
}
