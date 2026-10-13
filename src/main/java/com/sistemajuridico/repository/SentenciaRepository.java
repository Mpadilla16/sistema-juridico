package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Sentencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentenciaRepository extends JpaRepository<Sentencia,Integer> {
}
