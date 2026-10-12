package com.sistemajuridico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_rol")
    private Integer idUsuarioRol;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol",nullable = false)
    private Rol rol;
}
