package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "asignacion_proceso")
public class AsignacionProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion_proceso")
    private Integer idAsignacionProceso;

    @ManyToOne
    @JoinColumn(name = "id_proceso",nullable = false)
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_inicio",nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "motivo",length = 100)
    private String motivo;

    @Column(name = "activo",nullable = false)
    private Boolean activo;
}
