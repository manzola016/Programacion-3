package com.ejercicio.crudjava.servicios;

import com.ejercicio.crudjava.domain.entities.ContactoEmpresaEntity;

import java.util.List;

public interface ContactoEmpresaServicio {

    List<ContactoEmpresaEntity> obtenerRelaciones();

    ContactoEmpresaEntity crearRelacion(ContactoEmpresaEntity contactoEmpresaEntity);

    boolean eliminarRelacion(Long id);

}