package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "audiencia")
public class Audiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_audiencia")
    private Integer idAudiencia;

    @ManyToOne
    @JoinColumn(name = "id_providencia",nullable = false)
    private Providencia providencia;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "fecha_hora_audiencia")
    private LocalDateTime fechaHoraAudiencia;

    @Column(name = "audiencia_observaciones")
    private String audienciaObservaciones;

}
