package com.unicauca.tramites.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_configuraciones")
public class Configuraciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_configuraciones")
    private Long id;

    @Column(name = "mensaje_ping")
    private String mensajePing;
}
