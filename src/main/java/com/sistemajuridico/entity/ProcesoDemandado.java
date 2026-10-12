package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "proceso_demandado")
public class ProcesoDemandado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso_demandado")
    private Integer idProcesoDemandado;

    @ManyToOne
    @JoinColumn(name = "id_proceso",nullable = false)
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "id_demandado",nullable = false)
    private Demandado demandado;

    @Column(name = "observacion")
    private String observaciones;

}
