
package com.sistemajuridico.controller;

import com.sistemajuridico.entity.Providencia;
import com.sistemajuridico.service.ProvidenciaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/providencias")
@CrossOrigin(origins = "*")
public class ProvidenciaController {

    private final ProvidenciaService providenciaService;

    public ProvidenciaController(ProvidenciaService providenciaService) {
        this.providenciaService = providenciaService;
    }

    // Listar providencias
    @GetMapping
    public List<Providencia> listarProvidencias() {
        return providenciaService.listarProvidencias();
    }

    // Buscar por nombre parcial del demandado
    @GetMapping("/buscar/demandado")
    public List<Providencia> buscarPorNombreDemandado(
            @RequestParam String nombre) {
        return providenciaService.buscarPorNombreDemandado(nombre);
    }

    // Buscar por radicado parcial
    @GetMapping("/buscar/radicado")
    public List<Providencia> buscarPorRadicado(
            @RequestParam String radicado) {
        return providenciaService.buscarPorRadicado(radicado);
    }

    // Buscar por fecha de estado
    @GetMapping("/buscar/fecha-estado")
    public List<Providencia> buscarPorFechaEstado(
            @RequestParam LocalDate fecha) {
        return providenciaService.buscarPorFechaEstado(fecha);
    }

    // Buscar por número de estado
    @GetMapping("/buscar/numero-estado")
    public List<Providencia> buscarPorNumeroEstado(
            @RequestParam Integer numero) {
        return providenciaService.buscarPorNumeroEstado(numero);
    }

    // Buscar por tipo de auto
    @GetMapping("/buscar/tipo-auto")
    public List<Providencia> buscarPorTipoAuto(
            @RequestParam String nombre) {
        return providenciaService.buscarPorTipoAuto(nombre);
    }

    // Buscar por término de vencimiento
    @GetMapping("/buscar/termino-vence")
    public List<Providencia> buscarPorTerminoVence(
            @RequestParam LocalDate fecha) {
        return providenciaService.buscarPorTerminoVence(fecha);
    }

    // Registrar providencia
    @PostMapping
    public Providencia guardarProvidencia(
            @RequestBody Providencia providencia) {
        return providenciaService.guardarProvidencia(providencia);
    }
}
