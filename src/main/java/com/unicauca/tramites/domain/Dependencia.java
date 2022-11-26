package com.unicauca.tramites.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_dependencia")
public class Dependencia extends EntidadPrincipal {
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
}
