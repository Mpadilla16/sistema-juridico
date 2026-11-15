
package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNumeroDocumentoContaining(String numeroDocumento);

    List<Usuario> findByFechaCreacion(LocalDate fechaCreacion);
}

