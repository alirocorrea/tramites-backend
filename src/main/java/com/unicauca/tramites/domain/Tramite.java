package com.unicauca.tramites.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unicauca.tramites.domain.catalogo.TipoRecepcion;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_tramite")
@NoArgsConstructor
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    private Long id;

    @Column(name = "numerovu" )
    private Long numeroVU;

    @Column(name = "correo" )
    private String correo;

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
    private Boolean activo;

    @Column(name = "fecha_creacion_registro")
    private LocalDateTime fechaCreacionRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dependencia")
    private Dependencia dependencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_recepcion")
    private TipoRecepcion tipoRecepcion;



}
