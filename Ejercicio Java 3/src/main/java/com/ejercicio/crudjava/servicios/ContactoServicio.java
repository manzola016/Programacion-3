package com.ejercicio.crudjava.servicios;

import com.ejercicio.crudjava.domain.entities.ContactoEntity;

import java.util.List;

public interface ContactoServicio {

    List<ContactoEntity> obtenerContactos();

    ContactoEntity crearContacto(ContactoEntity contactoEntity);

    ContactoEntity actualizarContacto(Long id, ContactoEntity contactoEntity);

    boolean eliminarContacto(Long id);

    void generarReporte();

}
