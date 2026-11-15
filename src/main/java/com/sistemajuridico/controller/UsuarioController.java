
package com.sistemajuridico.controller;

import com.sistemajuridico.entity.Usuario;
import com.sistemajuridico.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/buscar/documento")
    public ResponseEntity<List<Usuario>> buscarPorDocumento(
            @RequestParam String documento) {
        return ResponseEntity.ok(usuarioService.buscarPorDocumento(documento));
    }

    @GetMapping("/buscar/fecha-creacion")
    public ResponseEntity<List<Usuario>> buscarPorFechaCreacion(
            @RequestParam LocalDate fecha) {
        return ResponseEntity.ok(usuarioService.buscarPorFechaCreacion(fecha));
    }

    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.guardar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Usuario> desactivar(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.desactivar(id));
    }
}
