package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre",nullable = false,length = 100)
    private String nombre;

    @Column(name = "tipo_documento",nullable = false,length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento",nullable = false,length = 50)
    private String numeroDocumento;

    @Column(name = "tp",nullable = false)
    private Integer tp;

    @Column(name = "correo",nullable = false, length = 100)
    private String correo;

    @Column(name = "telefono", length = 100)
    private String telefono;

    @Column(name = "estado",nullable = false)
    private Boolean estado;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDate fechaCreacion;


}
