package com.ejercicio.crudjava.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactoEmpresaDto {
    private Long id;
    private ContactoDto contacto;
    private EmpresaDto empresa;
    private String rol;
}
