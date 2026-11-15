
package com.sistemajuridico.repository;

import com.sistemajuridico.entity.Reparto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RepartoRepository extends JpaRepository<Reparto, Integer> {

    // Validar si un proceso ya tiene reparto
    boolean existsByProceso_IdProceso(Integer idProceso);

    // Buscar por fecha del acta
    List<Reparto> findByFechaActa(LocalDate fechaActa);

    // Buscar por radicado
    List<Reparto> findByRadicadoContainingIgnoreCase(String radicado);

    // Buscar por estado
    List<Reparto> findByEstado(Boolean estado);

    // Buscar por número de juzgado
    List<Reparto> findByJuzgado_NumeroJuzgado(Integer numeroJuzgado);

    // Buscar por nombre del juzgado
    List<Reparto> findByJuzgado_NombreContainingIgnoreCase(String nombre);

    // Buscar por entidad
    @Query("""
        SELECT r FROM Reparto r
        WHERE LOWER(r.proceso.entidad) LIKE LOWER(CONCAT('%', :entidad, '%'))
    """)
    List<Reparto> buscarPorEntidad(@Param("entidad") String entidad);

    // Buscar por especialidad
    @Query("""
        SELECT r FROM Reparto r
        WHERE LOWER(r.proceso.especialidad) LIKE LOWER(CONCAT('%', :especialidad, '%'))
    """)
    List<Reparto> buscarPorEspecialidad(@Param("especialidad") String especialidad);

    // Buscar por cuantía
    @Query("""
        SELECT r FROM Reparto r
        WHERE LOWER(r.proceso.cuantia) LIKE LOWER(CONCAT('%', :cuantia, '%'))
    """)
    List<Reparto> buscarPorCuantia(@Param("cuantia") String cuantia);

    // Buscar por nombre del demandante
    @Query("""
        SELECT DISTINCT r FROM Reparto r
        JOIN ProcesoDemandante pd ON pd.proceso.idProceso = r.proceso.idProceso
        JOIN pd.demandante d
        WHERE LOWER(d.nombreDemandante) LIKE LOWER(CONCAT('%', :nombre, '%'))
    """)
    List<Reparto> buscarPorDemandante(@Param("nombre") String nombre);

    // Buscar por nombre del demandado
    @Query("""
        SELECT DISTINCT r FROM Reparto r
        JOIN ProcesoDemandado pd ON pd.proceso.idProceso = r.proceso.idProceso
        JOIN pd.demandado d
        WHERE LOWER(d.nombreDemandado) LIKE LOWER(CONCAT('%', :nombre, '%'))
    """)
    List<Reparto> buscarPorDemandado(@Param("nombre") String nombre);
}
