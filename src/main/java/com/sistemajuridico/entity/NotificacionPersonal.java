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
@Table(name = "notificacion_personal")
public class NotificacionPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion_personal")
    private Integer idNotificacionPersonal;

    @ManyToOne
    @JoinColumn(name = "id_providencia",nullable = false)
    private Providencia providencia;

    @Column(name = "medio",length = 100)
    private String medio;

    @Column(name = "fecha_notificacion")
    private LocalDate fechaNotificacion;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "notificaciones_observaciones")
    private String notificacionObservaciones;

}
