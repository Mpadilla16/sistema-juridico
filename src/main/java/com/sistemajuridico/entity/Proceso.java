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

    @Column(name = "etapa_procesal", nullable = false, length = 100)
    private  String etapaProcesal;

    @Column(name = "tramo", length = 50)
    private String tramo;

    @Column(name = "numero_titulo_valor", length = 100)
    private String numeroTituloValor;

    @Column(name = "tipo_proceso", nullable = false,length = 50)
    private String tipoProceso;

    @Column(name = "pretensiones")
    private BigDecimal pretensiones;

    @Column(name = "departamento", length = 100)
    private String departamento;

    @Column(name = "ciudad",length = 100)
    private String ciudad;

    @Column(name = "cuantia", nullable = false,length = 100)
    private String cuantia;

    @Column(name = "entidad",length = 100)
    private String entidad;

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "fecha_presentacion")
    private LocalDate fechaPresentacion;

    @Column(name = "medidas_solicitadas",length = 255)
    private String medidasSolicitadas;

    @Column(name = "porcentaje_embargo")
    private BigDecimal porcentajeEmbargo;

    @Column(name = "link_exp",length = 255)
    private String linkExp;

    @Column(name = "estado", nullable = false)
    private Boolean estado;






}
