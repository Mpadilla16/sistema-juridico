
package com.sistemajuridico.controller;

import com.sistemajuridico.entity.MandamientoPago;
import com.sistemajuridico.service.MandamientoPagoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/mandamientos-pago")
@CrossOrigin(origins = "*")
public class MandamientoPagoController {

    private final MandamientoPagoService mandamientoPagoService;

    public MandamientoPagoController(MandamientoPagoService mandamientoPagoService) {
        this.mandamientoPagoService = mandamientoPagoService;
    }

    // Listar mandamientos de pago
    @GetMapping
    public List<MandamientoPago> listarMandamientosPago() {
        return mandamientoPagoService.listarMandamientosPago();
    }
    // Buscar por radicado parcial
    @GetMapping("/buscar/radicado")
    public List<MandamientoPago> buscarPorRadicado(
            @RequestParam String radicado) {
        return mandamientoPagoService.buscarPorRadicado(radicado);
    }
    // Buscar por nombre parcial del demandante
    @GetMapping("/buscar/demandante")
    public List<MandamientoPago> buscarPorDemandante(
            @RequestParam String nombre) {
        return mandamientoPagoService.buscarPorDemandante(nombre);
    }
    // Buscar por estado
    @GetMapping("/buscar/estado")
    public List<MandamientoPago> buscarPorEstado(
            @RequestParam Boolean estado) {
        return mandamientoPagoService.buscarPorEstado(estado);
    }
    // Buscar por fecha del auto
    @GetMapping("/buscar/fecha-auto")
    public List<MandamientoPago> buscarPorFechaAuto(
            @RequestParam LocalDate fecha) {
        return mandamientoPagoService.buscarPorFechaAuto(fecha);
    }
    // Buscar por fecha de publicación en estado
    @GetMapping("/buscar/fecha-estado")
    public List<MandamientoPago> buscarPorFechaEstado(
            @RequestParam LocalDate fecha) {
        return mandamientoPagoService.buscarPorFechaEstado(fecha);
    }
    // Registrar mandamiento de pago
    @PostMapping
    public MandamientoPago guardarMandamientoPago(
            @RequestBody MandamientoPago mandamientoPago) {
        return mandamientoPagoService.guardarMandamientoPago(mandamientoPago);
    }
}
