
package com.sistemajuridico.service;

import com.sistemajuridico.entity.MandamientoPago;
import com.sistemajuridico.repository.MandamientoPagoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MandamientoPagoService {

    private final MandamientoPagoRepository mandamientoPagoRepository;

    public MandamientoPagoService(MandamientoPagoRepository mandamientoPagoRepository) {
        this.mandamientoPagoRepository = mandamientoPagoRepository;
    }

    // Listar todos los mandamientos de pago
    public List<MandamientoPago> listarMandamientosPago() {
        return mandamientoPagoRepository.findAll();
    }
    // Buscar por radicado parcial
    public List<MandamientoPago> buscarPorRadicado(String radicado) {
        return mandamientoPagoRepository.buscarPorRadicado(radicado);
    }
    // Buscar por nombre parcial del demandante
    public List<MandamientoPago> buscarPorDemandante(String nombre) {
        return mandamientoPagoRepository.buscarPorDemandante(nombre);
    }
    // Buscar por estado
    public List<MandamientoPago> buscarPorEstado(Boolean estado) {
        return mandamientoPagoRepository.findByEstado(estado);
    }
    // Buscar por fecha del auto
    public List<MandamientoPago> buscarPorFechaAuto(LocalDate fecha) {
        return mandamientoPagoRepository.findByProvidencia_FechaAuto(fecha);
    }
    // Buscar por fecha de publicación en estado
    public List<MandamientoPago> buscarPorFechaEstado(LocalDate fecha) {
        return mandamientoPagoRepository.findByProvidencia_FechaEstado(fecha);
    }
    // Registrar mandamiento de pago
    public MandamientoPago guardarMandamientoPago(MandamientoPago mandamientoPago) {
        return mandamientoPagoRepository.save(mandamientoPago);
    }
}
