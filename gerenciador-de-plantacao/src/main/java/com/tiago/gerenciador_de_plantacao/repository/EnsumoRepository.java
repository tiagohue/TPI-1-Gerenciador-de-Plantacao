package com.tiago.gerenciador_de_plantacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.gerenciador_de_plantacao.entity.Ensumo;

public interface EnsumoRepository extends JpaRepository<Ensumo, Integer>{

}
