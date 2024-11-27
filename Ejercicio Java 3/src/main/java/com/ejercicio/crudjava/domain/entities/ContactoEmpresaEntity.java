package com.ejercicio.crudjava.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "contacto_empresa")
public class ContactoEmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacto_empresa_id_seq")
    @SequenceGenerator(name = "contacto_empresa_id_seq", sequenceName = "contacto_empresa_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contacto_id", nullable = false)
    private ContactoEntity contacto;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaEntity empresa;

    private String rol;
}