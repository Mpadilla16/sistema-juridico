package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medida_cautelar")
public class MedidaCautelar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medida_cautelar")
    private Integer idMedidaCautelar;

    @ManyToOne
    @JoinColumn(name = "id_providencia", nullable = false)
    private Providencia providencia;

    @Column(name = "limite_medida")
    private BigDecimal limiteMedida;

    @Column(name = "porcentaje_embargo")
    private BigDecimal porcentajeEmbargo;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "medida_cautelar_observaciones")
    private String medidaCautelarObservaciones;

}
