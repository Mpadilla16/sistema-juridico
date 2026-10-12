package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "terminacion")
public class Terminacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_terminacion")
    private Integer idTerminacion;

    @ManyToOne
    @JoinColumn(name = "id_providencia",nullable = false)
    private Providencia providencia;

    @Column(name = "causal_terminacion", length = 100)
    private String causalTerminacion;

    @Column(name = "terminacion_observaciones")
    private String terminacionObservaciones;

}
