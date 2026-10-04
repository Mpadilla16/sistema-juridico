package com.sistemajuridico.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "proceso")
public class Proceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso")
    private Integer idProceso;

    @Column(name = "etapa_procesal")
    private  String etapaProcesal;

    @Column(name = "tramo")
    private String tramo;

    @Column(name = "numero_titulo_valor")
    private String numeroTituloValor;

    @Column(name = "tipo_proceso")
    private String tipoProceso;

    @Column(name = "pretensiones")
    private BigDecimal pretensiones;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "cuantia")
    private String cuantia;

    @Column(name = "entidad")
    private String entidad;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "fecha_presentacion")
    private LocalDate fechaPresentacion;

    @Column(name = "medidas_solicitadas")
    private String medidasSolicitadas;

    @Column(name = "porcentaje_embargo")
    private BigDecimal porcentajeEmbargo;

    @Column(name = "link_exp")
    private String linkExp;

    @Column(name = "estado")
    private Boolean estado;






}
