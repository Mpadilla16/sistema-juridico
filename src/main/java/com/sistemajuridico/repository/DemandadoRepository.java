package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Demandado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandadoRepository extends JpaRepository<Demandado,Integer> {
}
