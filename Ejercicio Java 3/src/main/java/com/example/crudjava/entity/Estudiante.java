package com.example.crudjava.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudianteId;
    private String nombre;
    private String apellido;
    @Column(name = "correo_electronico", unique = true, nullable = false)
    private String correo;
}
