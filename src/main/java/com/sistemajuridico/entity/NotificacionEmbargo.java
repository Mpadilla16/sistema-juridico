package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "notificacion_embargo")
public class NotificacionEmbargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion_embargo")
    private Integer idNotificacionEmbargo;

    @ManyToOne
    @JoinColumn(name = "id_medida_cautelar", nullable = false)
    private MedidaCautelar medidaCautelar;

    @Column(name = "medida_notificada", length = 100)
    private String medidaNotificada;

    @Column(name = "fecha_notificacion")
    private LocalDate fechaNotificacion;

    @Column(name = "entidad")
    private String entidad;

    @Column(name = "notificacion_observaciones")
    private String notificacionObservaciones;

}
