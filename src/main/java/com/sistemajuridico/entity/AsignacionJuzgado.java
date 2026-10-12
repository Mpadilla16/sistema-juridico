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
@Table(name = "asignacion_juzgado")
public class AsignacionJuzgado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion_juzgado")
    private Integer idAsignacionJuzgado;

    @ManyToOne
    @JoinColumn(name = "id_juzgado", nullable = false)
    private Juzgado juzgado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}

