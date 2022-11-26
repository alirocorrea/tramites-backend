package com.unicauca.tramites.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "fecha_creacion_registro")
    private LocalDateTime fechaCreacion;

    @PrePersist
    @PreUpdate
    public void setDefaultValues() {
        if(activo == null) {
            this.activo = Boolean.TRUE;
        }
        if(fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }
    }
}
