
package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Demandado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandadoRepository extends JpaRepository<Demandado, Integer> {

    List<Demandado> findByNombreDemandadoContainingIgnoreCase(String nombreDemandado);

    List<Demandado> findByNumeroDocumentoContaining(String numeroDocumento);
}

