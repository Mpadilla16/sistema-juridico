
package com.sistemajuridico.controller;

import com.sistemajuridico.entity.ProcesoDemandante;
import com.sistemajuridico.service.ProcesoDemandanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procesos-demandantes")
@RequiredArgsConstructor
public class ProcesoDemandanteController {

    private final ProcesoDemandanteService procesoDemandanteService;

    @GetMapping
    public ResponseEntity<List<ProcesoDemandante>> listarTodos() {
        return ResponseEntity.ok(procesoDemandanteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ProcesoDemandante> guardar(
            @RequestBody ProcesoDemandante procesoDemandante) {

        ProcesoDemandante nuevo =
                procesoDemandanteService.guardar(procesoDemandante);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}

