
package com.sistemajuridico.service;

import com.sistemajuridico.entity.Providencia;
import com.sistemajuridico.repository.ProvidenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProvidenciaService {

    private final ProvidenciaRepository providenciaRepository;

    public ProvidenciaService(ProvidenciaRepository providenciaRepository) {
        this.providenciaRepository = providenciaRepository;
    }

    public List<Providencia> listarProvidencias() {
        return providenciaRepository.findAll();
    }

    public List<Providencia> buscarPorNombreDemandado(String nombre) {
        return providenciaRepository.buscarPorNombreDemandado(nombre);
    }

    public List<Providencia> buscarPorRadicado(String radicado) {
        return providenciaRepository.buscarPorRadicado(radicado);
    }

    public List<Providencia> buscarPorFechaEstado(LocalDate fecha) {
        return providenciaRepository.findByFechaEstado(fecha);
    }

    public List<Providencia> buscarPorNumeroEstado(Integer numero) {
        return providenciaRepository.findByNumeroEstado(numero);
    }

    public List<Providencia> buscarPorTipoAuto(String tipoAuto) {
        return providenciaRepository.findByTipoAutoContainingIgnoreCase(tipoAuto);
    }

    public List<Providencia> buscarPorTerminoVence(LocalDate fecha) {
        return providenciaRepository.findByTerminoVence(fecha);
    }

    public Providencia guardarProvidencia(Providencia providencia) {
        return providenciaRepository.save(providencia);
    }
}

