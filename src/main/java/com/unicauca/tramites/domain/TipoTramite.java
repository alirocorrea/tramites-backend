package com.unicauca.tramites.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_tipo_tramite")
@NoArgsConstructor
public class TipoTramite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_tramite")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "vigencia")
    private int vigencia;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_creacion_registro")
    private String fecha_registro;

    @OneToMany(mappedBy = "tipoTramite")
    @JsonIgnore
    List<Tramite> tramites;
}
