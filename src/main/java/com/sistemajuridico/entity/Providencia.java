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
@Table(name = "providencia")
public class Providencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_providencia")
    private Integer idProvidencia;

    @ManyToOne
    @JoinColumn(name = "id_actuacion")
    private Actuacion actuacion;

    @Column(name = "fecha_estado")
    private LocalDate fechaEstado;

    @Column(name = "numero_estado")
    private Integer numeroEstado;

    @Column(name = "tipo_auto")
    private String tipoAuto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "termino_vence")
    private LocalDate terminoVence;

    @Column(name = "observaciones_providencia")
    private String observacionesProvidencia;

    @Column(name = "fecha_auto")
    private LocalDate fechaAuto;


}
