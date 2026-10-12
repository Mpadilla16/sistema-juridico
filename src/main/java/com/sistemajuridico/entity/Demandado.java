package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "demandado")
public class Demandado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demandado")
    private Integer idDemandado;

    @Column(name = "tipo_documento",nullable = false,length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento",nullable = false, length = 50)
    private String numeroDocumento;

    @Column(name = "nombre_demandado",nullable = false, length = 100)
    private String nombreDemandado;

    @Column(name = "correo",length = 100)
    private String correo;

    @Column(name = "telefono",length = 20)
    private String telefono;

    @Column(name = "direccion",length = 100)
    private String direcion;

    @Column(name = "estado",nullable = false)
    private Boolean estado;

}
