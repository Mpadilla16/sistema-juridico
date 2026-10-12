package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sentencia")
public class Sentencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sentencia")
    private Integer idSentencia;

    @ManyToOne
    @JoinColumn(name = "id_providencia",nullable = false)
    private Providencia providencia;

    @Column(name = "sentencia_observaciones")
    private String sentenciaObservaciones;
}
