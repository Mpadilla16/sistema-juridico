
package com.sistemajuridico.service;

import com.sistemajuridico.entity.Usuario;
import com.sistemajuridico.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> buscarPorDocumento(String documento) {
        return usuarioRepository.findByNumeroDocumentoContaining(documento);
    }

    public List<Usuario> buscarPorFechaCreacion(LocalDate fecha) {
        return usuarioRepository.findByFechaCreacion(fecha);
    }

    public Usuario guardar(Usuario usuario) {
        if (usuario.getEstado() == null) {
            usuario.setEstado(true);
        }

        if (usuario.getFechaCreacion() == null) {
            usuario.setFechaCreacion(LocalDate.now());
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario desactivar(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setEstado(false);

        return usuarioRepository.save(usuario);
    }
}

