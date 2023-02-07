package com.unicauca.tramites.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_tramite")
public class Tramite extends EntidadPrincipal {

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
    private String numeroOficio;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dependencia")
    private Dependencia dependencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_recepcion")
    private TipoRecepcion tipoRecepcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_peticionario")
    private TipoPeticionario tipoPeticionario;

    @OneToMany(mappedBy = "tbl_tramite",  cascade = CascadeType.ALL)
    @OrderBy("fechaCreacion")
    private List<Traza> trazas;

}
