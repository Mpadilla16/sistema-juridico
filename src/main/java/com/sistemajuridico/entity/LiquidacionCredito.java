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
@Table(name = "liquidacion_credito")
public class LiquidacionCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion_credito")
    private Integer idLiquidacionCredito;

    @ManyToOne
    @JoinColumn(name = "id_providencia",nullable = false)
    private Providencia providencia;

    @Column(name = "valor_liquidacion")
    private BigDecimal valorLiquidacion;

    @Column(name = "liquidacion_credito_observaciones")
    private String liquidacionCreditoObservaciones;

}
