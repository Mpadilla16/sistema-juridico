package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rta_medida_cautelar")
public class RtaMedidaCautelar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rta_medida_cautelar")
    private Integer idRtaMedidaCautelar;

    @ManyToOne
    @JoinColumn(name = "id_notificacion_embargo", nullable = false)
    private NotificacionEmbargo notificacionEmbargo;

    @Column(name = "fecha_respuesta")
    private LocalDate fechaRespuesta;

    @Column(name = "respuesta", nullable = false)
    private String respuesta;

    @Column(name = "porcentaje")
    private BigDecimal porcentaje;

    @Column(name = "fecha_registro_embargo")
    private LocalDate fechaRegistroEmbargo;

    @Column(name = "fecha_opera_embargo")
    private LocalDate fechaOperaEmbargo;

    @Column(name = "estado")
    private Boolean estado;
}
