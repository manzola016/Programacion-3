package com.ejercicio.crudjava.servicios.impl;


import com.ejercicio.crudjava.domain.entities.ContactoEntity;
import com.ejercicio.crudjava.repositorios.ContactoRepositorio;
import com.ejercicio.crudjava.servicios.ContactoServicio;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class ContactoServicioImpl implements ContactoServicio {
    private ContactoRepositorio contactoRepositorio;

    public ContactoServicioImpl(ContactoRepositorio contactoRepositorio) {
        this.contactoRepositorio = contactoRepositorio;
    }

    @Override
    public List<ContactoEntity> obtenerContactos() {
        return (List<ContactoEntity>) contactoRepositorio.findAll();
    }

    @Override
    public ContactoEntity crearContacto(ContactoEntity contactoEntity) {
        return contactoRepositorio.save(contactoEntity);
    }

    @Override
    public ContactoEntity actualizarContacto(Long id, ContactoEntity contactoEntity) {
        if (contactoRepositorio.existsById(id)) {
            contactoEntity.setId(id);
            return contactoRepositorio.save(contactoEntity);
        } else {
            log.warning("Contacto con ID " + id + " no encontrado");
            return null;
        }
    }

    @Override
    public boolean eliminarContacto(Long id) {
        if (contactoRepositorio.existsById(id)) {
            contactoRepositorio.deleteById(id);
            return true;
        } else {
            log.warning("Contacto con ID " + id + " no encontrado");
            return false;
        }
    }
}
