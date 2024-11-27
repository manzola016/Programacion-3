package com.ejercicio.crudjava.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactoDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
}
