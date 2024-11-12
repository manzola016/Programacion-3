package com.ejercicio.crudjava.servicios;

import com.ejercicio.crudjava.domain.entities.ContactoEntity;

public interface ContactoServicio {
    ContactoEntity crearContacto(ContactoEntity contactoEntity);

    ContactoEntity actualizarContacto(Long id, ContactoEntity contactoEntity);

    boolean eliminarContacto(Long id);
}
