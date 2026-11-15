
package com.sistemajuridico.controller;

import com.sistemajuridico.entity.Actuacion;
import com.sistemajuridico.service.ActuacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actuaciones")
@CrossOrigin(origins = "*")
public class ActuacionController {

    private final ActuacionService actuacionService;

    public ActuacionController(ActuacionService actuacionService) {
        this.actuacionService = actuacionService;
    }

    // Listar todas las actuaciones
    @GetMapping
    public List<Actuacion> listarActuaciones() {
        return actuacionService.listarActuaciones();
    }

    // Buscar por tipo de actuación
    @GetMapping("/buscar/tipo")
    public List<Actuacion> buscarPorTipo(@RequestParam String nombre) {
        return actuacionService.buscarPorTipo(nombre);
    }

    // Buscar por radicado del proceso
    @GetMapping("/buscar/radicado")
    public List<Actuacion> buscarPorRadicado(@RequestParam String radicado) {
        return actuacionService.buscarPorRadicado(radicado);
    }

    // Buscar por nombre parcial del demandante
    @GetMapping("/buscar/demandante")
    public List<Actuacion> buscarPorDemandante(@RequestParam String nombre) {
        return actuacionService.buscarPorDemandante(nombre);
    }

    // Buscar por nombre parcial del demandado
    @GetMapping("/buscar/demandado")
    public List<Actuacion> buscarPorDemandado(@RequestParam String nombre) {
        return actuacionService.buscarPorDemandado(nombre);
    }

    // Registrar una actuación
    @PostMapping
    public Actuacion guardarActuacion(@RequestBody Actuacion actuacion) {
        return actuacionService.guardarActuacion(actuacion);
    }
}
