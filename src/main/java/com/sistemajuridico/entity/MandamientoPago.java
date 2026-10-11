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
@Table(name = "mandamiento_pago")
public class MandamientoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mandamiento_pago")
    private Integer idMandamientoPago;

    @ManyToOne
    @JoinColumn(name = "id_providencia", nullable = false)
    private Providencia providencia;

    @Column(name = "valor_mto_pago")
    private BigDecimal valorMtoPago;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "mto_pago_observaciones")
    private String mtoPagoObservaciones;

}
