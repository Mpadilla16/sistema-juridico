
package com.sistemajuridico.service;

import com.sistemajuridico.entity.ProcesoDemandado;
import com.sistemajuridico.repository.ProcesoDemandadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcesoDemandadoService {

    private final ProcesoDemandadoRepository procesoDemandadoRepository;

    public List<ProcesoDemandado> listarTodos() {
        return procesoDemandadoRepository.findAll();
    }

    public ProcesoDemandado guardar(ProcesoDemandado procesoDemandado) {
        return procesoDemandadoRepository.save(procesoDemandado);
    }
}
