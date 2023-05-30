package com.br.global.apialimentos.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findAllByAtivoTrue();
}
