
package com.sistemajuridico.service;

import com.sistemajuridico.entity.Actuacion;
import com.sistemajuridico.repository.ActuacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuacionService {

    private final ActuacionRepository actuacionRepository;

    public ActuacionService(ActuacionRepository actuacionRepository) {
        this.actuacionRepository = actuacionRepository;
    }

    public List<Actuacion> listarActuaciones() {
        return actuacionRepository.findAll();
    }

    public List<Actuacion> buscarPorTipo(String nombreTipo) {
        return actuacionRepository
                .findByTipoActuacion_NombreTipoContainingIgnoreCase(nombreTipo);
    }

    public List<Actuacion> buscarPorRadicado(String radicado) {
        return actuacionRepository.buscarPorRadicado(radicado);
    }

    public List<Actuacion> buscarPorDemandante(String nombre) {
        return actuacionRepository.buscarPorNombreDemandante(nombre);
    }

    public List<Actuacion> buscarPorDemandado(String nombre) {
        return actuacionRepository.buscarPorNombreDemandado(nombre);
    }

    public Actuacion guardarActuacion(Actuacion actuacion) {
        return actuacionRepository.save(actuacion);
    }
}
