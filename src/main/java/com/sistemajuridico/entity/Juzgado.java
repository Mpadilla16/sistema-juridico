package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "juzgado")
public class Juzgado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juzgado")
    private Integer idJuzgado;

    @Column(name = "departamento", length = 100)
    private String departamento;

    @Column(name = "ciudad", length = 100)
    private String ciudad;

    @Column(name = "cuantia", nullable = false, length = 100)
    private String cuantia;

    @Column(name = "entidad", nullable = false, length = 100)
    private String entidad;

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "numero_juzgado")
    private Integer numeroJuzgado;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "telefono", length = 100)
    private String telefono;

    @Column(name = "direccion", length = 100)
    private String direccion;
}

