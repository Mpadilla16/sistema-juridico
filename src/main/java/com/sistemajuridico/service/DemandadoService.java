
package com.sistemajuridico.service;

import com.sistemajuridico.entity.Demandado;
import com.sistemajuridico.repository.DemandadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandadoService {

    private final DemandadoRepository demandadoRepository;

    public List<Demandado> listarTodos() {
        return demandadoRepository.findAll();
    }

    public List<Demandado> buscarPorNombre(String nombre) {
        return demandadoRepository.findByNombreDemandadoContainingIgnoreCase(nombre);
    }

    public List<Demandado> buscarPorDocumento(String documento) {
        return demandadoRepository.findByNumeroDocumentoContaining(documento);
    }

    public Demandado guardar(Demandado demandado) {
        if (demandado.getEstado() == null) {
            demandado.setEstado(true);
        }

        return demandadoRepository.save(demandado);
    }

    public Demandado desactivar(Integer id) {
        Demandado demandado = demandadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demandado no encontrado"));

        demandado.setEstado(false);

        return demandadoRepository.save(demandado);
    }
}
