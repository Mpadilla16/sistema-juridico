package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Demandante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DemandanteRepository extends JpaRepository<Demandante,Integer> {

    Optional<Demandante> findByNumeroDocumento(String numeroDocumento);

    List<Demandante> findByNombreDemandanteContainingIgnoreCase(String nombre);

}
