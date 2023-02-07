package com.unicauca.tramites.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_tipo_tramite")
public class TipoTramite extends EntidadPrincipal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_tramite")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "vigencia")
    private int vigencia;

}
