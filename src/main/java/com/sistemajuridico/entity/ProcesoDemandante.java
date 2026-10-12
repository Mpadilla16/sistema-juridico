package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "proceso_demandante")
public class ProcesoDemandante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso_demandante")
    private Integer idProcesoDemandante;

    @ManyToOne
    @JoinColumn(name = "id_proceso",nullable = false)
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "id_demandante",nullable = false)
    private Demandante demandante;

    @Column(name = "observacion")
    private String observacion;

}
