
package com.sistemajuridico.service;

import com.sistemajuridico.entity.ProcesoDemandante;
import com.sistemajuridico.repository.ProcesoDemandanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcesoDemandanteService {

    private final ProcesoDemandanteRepository procesoDemandanteRepository;

    public List<ProcesoDemandante> listarTodos() {
        return procesoDemandanteRepository.findAll();
    }

    public ProcesoDemandante guardar(ProcesoDemandante procesoDemandante) {
        return procesoDemandanteRepository.save(procesoDemandante);
    }
}
