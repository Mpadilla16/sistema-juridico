package com.sistemajuridico.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name ="tipo_actuacion")
public class TipoActuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_actuacion")
    private Integer idTipoActuacion;

    @Column(name = "nombre_tipo",length = 50)
    private String nombreTipo;


}
