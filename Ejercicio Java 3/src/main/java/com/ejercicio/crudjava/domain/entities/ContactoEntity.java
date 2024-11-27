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
@Table(name = "contactos")
public class ContactoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacto_id_seq")
    @SequenceGenerator(name = "contacto_id_seq", sequenceName = "contacto_id_seq", allocationSize = 1)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;

    @OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContactoEmpresaEntity> relaciones;
}
