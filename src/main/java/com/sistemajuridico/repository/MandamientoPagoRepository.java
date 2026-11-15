
package com.sistemajuridico.repository;

import com.sistemajuridico.entity.MandamientoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MandamientoPagoRepository extends JpaRepository<MandamientoPago, Integer> {

    // Buscar por radicado parcial
    @Query("""
        SELECT DISTINCT m
        FROM MandamientoPago m
        WHERE EXISTS (
            SELECT r.idReparto
            FROM Reparto r
            WHERE r.proceso = m.providencia.actuacion.proceso
            AND LOWER(r.radicado)
                LIKE LOWER(CONCAT('%', :radicado, '%'))
        )
    """)
    List<MandamientoPago> buscarPorRadicado(@Param("radicado") String radicado);

    // Buscar por nombre parcial del demandante
    @Query("""
        SELECT DISTINCT m
        FROM MandamientoPago m
        WHERE EXISTS (
            SELECT pd.idProcesoDemandante
            FROM ProcesoDemandante pd
            WHERE pd.proceso = m.providencia.actuacion.proceso
            AND LOWER(pd.demandante.nombreDemandante)
                LIKE LOWER(CONCAT('%', :nombre, '%'))
        )
    """)
    List<MandamientoPago> buscarPorDemandante(@Param("nombre") String nombre);

    // Buscar por estado
    List<MandamientoPago> findByEstado(Boolean estado);

    // Buscar por fecha del auto
    List<MandamientoPago> findByProvidencia_FechaAuto(LocalDate fechaAuto);

    // Buscar por fecha de publicación en estado
    List<MandamientoPago> findByProvidencia_FechaEstado(LocalDate fechaEstado);
}
