package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Demandante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandanteRepository extends JpaRepository<Demandante,Integer> {
}
