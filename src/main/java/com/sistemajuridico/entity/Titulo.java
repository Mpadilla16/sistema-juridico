package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "titulo")
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titulo")
    private Integer idTitulo;

    @ManyToOne
    @JoinColumn(name = "id_proceso",nullable = false)
    private Proceso proceso;

    @Column(name = "origen", length = 100)
    private String origen;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "entregado")
    private Boolean entregado;

    @Column(name = "titulo_observaciones")
    private String tituloObservaciones;
}
