
package com.sistemajuridico.controller;

import com.sistemajuridico.entity.Demandado;
import com.sistemajuridico.service.DemandadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandados")
@RequiredArgsConstructor
public class DemandadoController {

    private final DemandadoService demandadoService;

    @GetMapping
    public ResponseEntity<List<Demandado>> listarTodos() {
        return ResponseEntity.ok(demandadoService.listarTodos());
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<Demandado>> buscarPorNombre(
            @RequestParam String nombre) {
        return ResponseEntity.ok(demandadoService.buscarPorNombre(nombre));
    }

    @GetMapping("/buscar/documento")
    public ResponseEntity<List<Demandado>> buscarPorDocumento(
            @RequestParam String documento) {
        return ResponseEntity.ok(demandadoService.buscarPorDocumento(documento));
    }

    @PostMapping
    public ResponseEntity<Demandado> guardar(@RequestBody Demandado demandado) {
        Demandado nuevo = demandadoService.guardar(demandado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Demandado> desactivar(@PathVariable Integer id) {
        return ResponseEntity.ok(demandadoService.desactivar(id));
    }
}

