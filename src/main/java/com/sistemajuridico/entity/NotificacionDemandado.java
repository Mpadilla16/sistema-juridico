package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "notificacion_demandado")
public class NotificacionDemandado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion_demandado")
    private Integer idNotificacionDemandado;

    @ManyToOne
    @JoinColumn(name = "id_notificacion_personal",nullable = false)
    private NotificacionPersonal notificacionPersonal;

    @ManyToOne
    @JoinColumn(name = "id_demandado",nullable = false)
    private Demandado demandado;
}