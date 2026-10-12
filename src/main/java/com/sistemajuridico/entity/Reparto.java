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
@Table(name = "reparto")
public class Reparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparto")
    private Integer idReparto;

    @ManyToOne
    @JoinColumn(name = "id_proceso",nullable = false)
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "id_juzgado",nullable = false)
    private Juzgado juzgado;

    @Column(name = "fecha_acta")
    private LocalDate fechaActa;

    @Column(name = "radicado",length = 100)
    private String radicado;

    @Column(name = "estado",nullable = false)
    private Boolean estado;

    @Column(name = "motivo",length = 100)
    private String motivo;

    @Column(name = "reparto_observaciones")
    private String repartoObservaciones;

}
