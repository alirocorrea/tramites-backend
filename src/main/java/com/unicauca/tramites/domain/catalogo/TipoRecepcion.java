package com.unicauca.tramites.domain.catalogo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cat_tipo_recepcion")
@NoArgsConstructor
public class TipoRecepcion {

    @Id
    @Column(name = "id_tramite")
    private Long id;

    @Column(name = "numerovu" )
    private String descripcion;
}
