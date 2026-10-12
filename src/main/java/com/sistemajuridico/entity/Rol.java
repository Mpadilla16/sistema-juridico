package com.sistemajuridico.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre",length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion",length = 255)
    private String descripcion;

    @Column(name = "estado",nullable = false)
    private Boolean estado;
}
