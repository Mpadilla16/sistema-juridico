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
@Table(name = "gestion_externa")
public class GestionExterna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gestion_externa")
    private Integer idGestionExterna;

    @ManyToOne
    @JoinColumn(name = "id_actuacion")
    private Actuacion actuacion;

    @Column(name = "tipo_memorial")
    private String tipoMemorial;

    @Column(name = "estado_envio")
    private String estadoEnvio;

    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

    @Column(name = "gestion_externa_observaciones")
    private String gestionExternaObservaciones;

    @Column(name = "interrumpe_desistimiento")
    private Boolean interrumpeDesistimiento;


}
