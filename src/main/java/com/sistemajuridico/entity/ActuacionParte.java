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
@Table(name = "actuacion_parte")
public class ActuacionParte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActuacionParte;

    @ManyToOne
    @JoinColumn(name = "id_actuacion")
    private Actuacion actuacion;

    @Column(name = "nombre_actuacion")
    private String nombreActuacion;

    @Column(name = "presentado_por")
    private String presentadoPor;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "interrumpe_desistimiento")
    private Boolean interrumpeDesistimiento;
}