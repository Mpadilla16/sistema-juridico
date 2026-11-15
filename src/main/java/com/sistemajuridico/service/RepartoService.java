
package com.sistemajuridico.service;

import com.sistemajuridico.entity.Reparto;
import com.sistemajuridico.entity.Proceso;
import com.sistemajuridico.entity.Juzgado;
import com.sistemajuridico.repository.RepartoRepository;
import com.sistemajuridico.repository.ProcesoRepository;
import com.sistemajuridico.repository.JuzgadoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RepartoService {

    private final RepartoRepository repartoRepository;
    private final ProcesoRepository procesoRepository;
    private final JuzgadoRepository juzgadoRepository;

    // Listar todos
    public List<Reparto> listarTodos() {
        return repartoRepository.findAll();
    }

    // Buscar por fecha del acta
    public List<Reparto> buscarPorFechaActa(LocalDate fecha) {
        return repartoRepository.findByFechaActa(fecha);
    }

    // Buscar por radicado
    public List<Reparto> buscarPorRadicado(String radicado) {
        return repartoRepository.findByRadicadoContainingIgnoreCase(radicado);
    }

    // Buscar por estado
    public List<Reparto> buscarPorEstado(Boolean estado) {
        return repartoRepository.findByEstado(estado);
    }

    // Buscar por número de juzgado
    public List<Reparto> buscarPorNumeroJuzgado(Integer numero) {
        return repartoRepository.findByJuzgado_NumeroJuzgado(numero);
    }

    // Buscar por nombre del juzgado
    public List<Reparto> buscarPorNombreJuzgado(String nombre) {
        return repartoRepository.findByJuzgado_NombreContainingIgnoreCase(nombre);
    }

    // Buscar por entidad
    public List<Reparto> buscarPorEntidad(String entidad) {
        return repartoRepository.buscarPorEntidad(entidad);
    }

    // Buscar por especialidad
    public List<Reparto> buscarPorEspecialidad(String especialidad) {
        return repartoRepository.buscarPorEspecialidad(especialidad);
    }

    // Buscar por cuantía
    public List<Reparto> buscarPorCuantia(String cuantia) {
        return repartoRepository.buscarPorCuantia(cuantia);
    }

    // Buscar por demandante
    public List<Reparto> buscarPorDemandante(String nombre) {
        return repartoRepository.buscarPorDemandante(nombre);
    }

    // Buscar por demandado
    public List<Reparto> buscarPorDemandado(String nombre) {
        return repartoRepository.buscarPorDemandado(nombre);
    }

    // Registrar reparto
    @Transactional
    public Reparto guardar(Reparto reparto) {

        if (reparto.getProceso() == null
                || reparto.getProceso().getIdProceso() == null) {
            throw new IllegalArgumentException("Debe indicar el proceso");
        }

        if (reparto.getJuzgado() == null
                || reparto.getJuzgado().getIdJuzgado() == null) {
            throw new IllegalArgumentException("Debe indicar el juzgado");
        }

        Integer idProceso = reparto.getProceso().getIdProceso();
        Integer idJuzgado = reparto.getJuzgado().getIdJuzgado();

        Proceso proceso = procesoRepository.findById(idProceso)
                .orElseThrow(() ->
                        new EntityNotFoundException("Proceso no encontrado"));

        Juzgado juzgado = juzgadoRepository.findById(idJuzgado)
                .orElseThrow(() ->
                        new EntityNotFoundException("Juzgado no encontrado"));

        if (repartoRepository.existsByProceso_IdProceso(idProceso)) {
            throw new IllegalArgumentException(
                    "Este proceso ya tiene un reparto registrado");
        }

        boolean coincide =
                Objects.equals(proceso.getDepartamento(), juzgado.getDepartamento())
                        && Objects.equals(proceso.getCiudad(), juzgado.getCiudad())
                        && Objects.equals(proceso.getCuantia(), juzgado.getCuantia())
                        && Objects.equals(proceso.getEntidad(), juzgado.getEntidad())
                        && Objects.equals(proceso.getEspecialidad(), juzgado.getEspecialidad());

        if (!coincide) {
            throw new IllegalArgumentException(
                    "El juzgado no corresponde a las características del proceso");
        }

        reparto.setProceso(proceso);
        reparto.setJuzgado(juzgado);

        if (reparto.getEstado() == null) {
            reparto.setEstado(true);
        }

        Reparto nuevoReparto = repartoRepository.save(reparto);

        proceso.setEtapaProcesal("Acta de reparto");
        procesoRepository.save(proceso);

        return nuevoReparto;
    }
}
