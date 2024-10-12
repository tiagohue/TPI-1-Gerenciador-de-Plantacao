package com.tiago.gerenciador_de_plantacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.gerenciador_de_plantacao.entity.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Integer>{

}
