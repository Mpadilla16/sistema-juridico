
package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "demandante")
public class Demandante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demandante")
    private Integer idDemandante;

    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, length = 50)
    private String numeroDocumento;

    @Column(name = "nombre_demandante", nullable = false, length = 100)
    private String nombreDemandante;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}

