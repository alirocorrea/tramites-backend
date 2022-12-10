package com.unicauca.tramites.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cat_tipo_peticionario")
public class TipoPeticionario implements Serializable {

    @Id
    @Column(name = "id_tipo_peticionario")
    private Long id;

    @Column(name = "descripcion" )
    private String descripcion;
}
