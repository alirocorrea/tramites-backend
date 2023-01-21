package com.unicauca.tramites.domain;

import com.unicauca.tramites.domain.Dependencia;
import com.unicauca.tramites.domain.EntidadPrincipal;
import com.unicauca.tramites.domain.Tramite;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_traza")
public class Traza extends EntidadPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_traza")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dependencia")
    private Dependencia dependencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tbl_tramite;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "numero_oficio")
    private String numeroOficio;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

}
