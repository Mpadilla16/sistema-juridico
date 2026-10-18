
package com.sistemajuridico.service;

import com.sistemajuridico.entity.Demandante;
import com.sistemajuridico.repository.DemandanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandanteService {

    private final DemandanteRepository demandanteRepository;

    public DemandanteService(DemandanteRepository demandanteRepository) {
        this.demandanteRepository = demandanteRepository;
    }

    public List<Demandante> listarDemandantes() {
        return demandanteRepository.findAll();
    }

    public Optional<Demandante> buscarDemandantePorDocumento(String numeroDocumento) {
        return demandanteRepository.findByNumeroDocumento(numeroDocumento);
    }

    public List<Demandante> buscarDemandantesPorNombre(String nombre) {
        return demandanteRepository.findByNombreDemandanteContainingIgnoreCase(nombre);
    }

    public Demandante guardarDemandante(Demandante demandante) {
        return demandanteRepository.save(demandante);
    }

    public void desactivarDemandante(String numeroDocumento) {
        demandanteRepository.findByNumeroDocumento(numeroDocumento)
                .ifPresent(demandante -> {
                    demandante.setEstado(false);
                    demandanteRepository.save(demandante);
                });
    }
}

