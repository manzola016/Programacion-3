package com.ejercicio.crudjava.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contacto {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
}
