package com.unicauca.tramites.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_tramite")
@NoArgsConstructor
public class Tramite implements Serializable {

    @Id
    @Column(name = "id_tramite")
    private Long idTramite;

    @Column(name = "numerovu" )
    private long numeroVU;

    @Column(name = "fecha_recepcion")
    private LocalDate fechaRecepcion;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "fecha_respuesta")
    private LocalDate fechaRespuesta;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "numero_oficio")
    private String numOficio;

    @Column(name = "nombre_peticionario")
    private String nombrePeticionario;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "fecha_creacion_registro")
    private String fechaCreacionRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dependencia")
    private Dependencia dependencia;



}
