
package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Providencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProvidenciaRepository extends JpaRepository<Providencia, Integer> {

    // Buscar providencias por nombre parcial del demandado
    @Query("""
        SELECT DISTINCT p
        FROM Providencia p
        WHERE EXISTS (
            SELECT pd.idProcesoDemandado
            FROM ProcesoDemandado pd
            WHERE pd.proceso = p.actuacion.proceso
            AND LOWER(pd.demandado.nombreDemandado)
                LIKE LOWER(CONCAT('%', :nombre, '%'))
        )
    """)
    List<Providencia> buscarPorNombreDemandado(@Param("nombre") String nombre);

    // Buscar providencias por radicado parcial
    @Query("""
        SELECT DISTINCT p
        FROM Providencia p
        WHERE EXISTS (
            SELECT r.idReparto
            FROM Reparto r
            WHERE r.proceso = p.actuacion.proceso
            AND LOWER(r.radicado)
                LIKE LOWER(CONCAT('%', :radicado, '%'))
        )
    """)
    List<Providencia> buscarPorRadicado(@Param("radicado") String radicado);

    // Buscar por fecha de estado
    List<Providencia> findByFechaEstado(LocalDate fechaEstado);

    // Buscar por número de estado
    List<Providencia> findByNumeroEstado(Integer numeroEstado);

    // Buscar por tipo de auto, coincidencia parcial
    List<Providencia> findByTipoAutoContainingIgnoreCase(String tipoAuto);

    // Buscar por fecha de vencimiento
    List<Providencia> findByTerminoVence(LocalDate terminoVence);
}
