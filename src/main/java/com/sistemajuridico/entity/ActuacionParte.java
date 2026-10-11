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
    @Column(name = "id_actuacion_parte")
    private Integer idActuacionParte;

    @ManyToOne
    @JoinColumn(name = "id_actuacion", nullable = false)
    private Actuacion actuacion;

    @Column(name = "nombre_actuacion", nullable = false, length = 100)
    private String nombreActuacion;

    @Column(name = "presentado_por", nullable = false, length = 100)
    private String presentadoPor;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "interrumpe_desistimiento")
    private Boolean interrumpeDesistimiento;
}