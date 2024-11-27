package com.ejercicio.crudjava.servicios.impl;

import com.ejercicio.crudjava.domain.entities.ContactoEmpresaEntity;
import com.ejercicio.crudjava.repositorios.ContactoEmpresaRepositorio;
import com.ejercicio.crudjava.servicios.ContactoEmpresaServicio;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class ContactoEmpresaServicioImpl implements ContactoEmpresaServicio {
    private final ContactoEmpresaRepositorio contactoEmpresaRepositorio;

    public ContactoEmpresaServicioImpl(ContactoEmpresaRepositorio contactoEmpresaRepositorio) {
        this.contactoEmpresaRepositorio = contactoEmpresaRepositorio;
    }

    @Override
    public List<ContactoEmpresaEntity> obtenerRelaciones() {
        return (List<ContactoEmpresaEntity>) contactoEmpresaRepositorio.findAll();
    }

    @Override
    public ContactoEmpresaEntity crearRelacion(ContactoEmpresaEntity contactoEmpresaEntity) {
        return contactoEmpresaRepositorio.save(contactoEmpresaEntity);
    }

    @Override
    public boolean eliminarRelacion(Long id) {
        if (contactoEmpresaRepositorio.existsById(id)) {
            contactoEmpresaRepositorio.deleteById(id);
            return true;
        } else {
            log.warning("Relacion Contacto-Empresa con ID " + id + " no encontrada");
            return false;
        }
    }
}
