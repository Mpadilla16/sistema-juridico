package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "apoderado_proceso")
public class ApoderadoProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apoderado_proceso")
    private Integer idApoderadoProceso;

    @ManyToOne
    @JoinColumn(name = "id_proceso",nullable = false)
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "motivo",length = 100)
    private String motivo;

    @Column(name = "activo",nullable = false)
    private Boolean activo;
}
