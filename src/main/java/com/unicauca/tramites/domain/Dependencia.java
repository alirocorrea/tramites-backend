package com.unicauca.tramites.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_dependencia")
@NoArgsConstructor
public class Dependencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dependencia")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nombre_encargado")
    private String nombreEncargado;

    @Column(name = "correo_encargado")
    private String correoEncargado;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_creacion_registro")
    private String fecha_registro;

    @OneToMany(mappedBy = "dependencia")
    @JsonIgnore
    List<Tramite> tramites;
}
