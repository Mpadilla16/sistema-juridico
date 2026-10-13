package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Proceso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcesoRepository extends JpaRepository<Proceso,Integer> {
}
