
package com.sistemajuridico.controller;

import com.sistemajuridico.entity.Reparto;
import com.sistemajuridico.service.RepartoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/repartos")
@RequiredArgsConstructor
public class RepartoController {

    private final RepartoService repartoService;

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Reparto>> listarTodos() {
        return ResponseEntity.ok(repartoService.listarTodos());
    }

    // Buscar por fecha del acta
    @GetMapping("/buscar/fecha-acta")
    public ResponseEntity<List<Reparto>> buscarPorFechaActa(
            @RequestParam LocalDate fecha) {
        return ResponseEntity.ok(repartoService.buscarPorFechaActa(fecha));
    }

    // Buscar por radicado
    @GetMapping("/buscar/radicado")
    public ResponseEntity<List<Reparto>> buscarPorRadicado(
            @RequestParam String radicado) {
        return ResponseEntity.ok(repartoService.buscarPorRadicado(radicado));
    }

    // Buscar por estado
    @GetMapping("/buscar/estado")
    public ResponseEntity<List<Reparto>> buscarPorEstado(
            @RequestParam Boolean estado) {
        return ResponseEntity.ok(repartoService.buscarPorEstado(estado));
    }

    // Buscar por número de juzgado
    @GetMapping("/buscar/numero-juzgado")
    public ResponseEntity<List<Reparto>> buscarPorNumeroJuzgado(
            @RequestParam Integer numero) {
        return ResponseEntity.ok(repartoService.buscarPorNumeroJuzgado(numero));
    }

    // Buscar por nombre del juzgado
    @GetMapping("/buscar/nombre-juzgado")
    public ResponseEntity<List<Reparto>> buscarPorNombreJuzgado(
            @RequestParam String nombre) {
        return ResponseEntity.ok(repartoService.buscarPorNombreJuzgado(nombre));
    }

    // Buscar por entidad
    @GetMapping("/buscar/entidad")
    public ResponseEntity<List<Reparto>> buscarPorEntidad(
            @RequestParam String entidad) {
        return ResponseEntity.ok(repartoService.buscarPorEntidad(entidad));
    }

    // Buscar por especialidad
    @GetMapping("/buscar/especialidad")
    public ResponseEntity<List<Reparto>> buscarPorEspecialidad(
            @RequestParam String especialidad) {
        return ResponseEntity.ok(repartoService.buscarPorEspecialidad(especialidad));
    }

    // Buscar por cuantía
    @GetMapping("/buscar/cuantia")
    public ResponseEntity<List<Reparto>> buscarPorCuantia(
            @RequestParam String cuantia) {
        return ResponseEntity.ok(repartoService.buscarPorCuantia(cuantia));
    }

    // Buscar por demandante
    @GetMapping("/buscar/demandante")
    public ResponseEntity<List<Reparto>> buscarPorDemandante(
            @RequestParam String nombre) {
        return ResponseEntity.ok(repartoService.buscarPorDemandante(nombre));
    }

    // Buscar por demandado
    @GetMapping("/buscar/demandado")
    public ResponseEntity<List<Reparto>> buscarPorDemandado(
            @RequestParam String nombre) {
        return ResponseEntity.ok(repartoService.buscarPorDemandado(nombre));
    }

    // Registrar reparto
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Reparto reparto) {
        try {
            Reparto nuevoReparto = repartoService.guardar(reparto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReparto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
