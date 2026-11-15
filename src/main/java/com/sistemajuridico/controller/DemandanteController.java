package com.sistemajuridico.controller;

import com.sistemajuridico.entity.Demandante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sistemajuridico.service.DemandanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/api/demandantes")
public class DemandanteController {

    private final DemandanteService demandanteService;

    public DemandanteController(DemandanteService demandanteService) {
        this.demandanteService = demandanteService;
    }

    @GetMapping
    public List<Demandante> listarDemandantes() {
        return demandanteService.listarDemandantes();
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<Demandante> buscarPorDocumento(
            @PathVariable String numeroDocumento) {

        return demandanteService.buscarDemandantePorDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public List<Demandante> buscarPorNombre(@RequestParam String nombre) {
        return demandanteService.buscarDemandantesPorNombre(nombre);

    }

    @PostMapping
    public Demandante registrarDemandante(@RequestBody Demandante demandante) {
        return demandanteService.guardarDemandante(demandante);
    }

}
