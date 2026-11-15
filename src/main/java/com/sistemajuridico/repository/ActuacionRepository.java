
package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Actuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActuacionRepository extends JpaRepository<Actuacion, Integer> {

    @Query("""
        SELECT DISTINCT a
        FROM Actuacion a, ProcesoDemandante pd, Demandante d
        WHERE pd.proceso = a.proceso
        AND pd.demandante = d
        AND LOWER(d.nombreDemandante) LIKE LOWER(CONCAT('%', :nombre, '%'))
    """)
    List<Actuacion> buscarPorNombreDemandante(@Param("nombre") String nombre);

    @Query("""
        SELECT DISTINCT a
        FROM Actuacion a, ProcesoDemandado pd, Demandado d
        WHERE pd.proceso = a.proceso
        AND pd.demandado = d
        AND LOWER(d.nombreDemandado) LIKE LOWER(CONCAT('%', :nombre, '%'))
    """)
    List<Actuacion> buscarPorNombreDemandado(@Param("nombre") String nombre);

    List<Actuacion> findByTipoActuacion_NombreTipoContainingIgnoreCase(String nombreTipo);

    @Query("""
        SELECT DISTINCT a
        FROM Actuacion a
        WHERE a.proceso.idProceso IN (
            SELECT r.proceso.idProceso
            FROM Reparto r
            WHERE LOWER(r.radicado) LIKE LOWER(CONCAT('%', :radicado, '%'))
        )
    """)
    List<Actuacion> buscarPorRadicado(@Param("radicado") String radicado);
}

