package com.ejercicio.crudjava.controladores;

import com.ejercicio.crudjava.domain.dto.ContactoDto;
import com.ejercicio.crudjava.domain.entities.ContactoEntity;
import com.ejercicio.crudjava.mappers.impl.ContactoMapper;
import com.ejercicio.crudjava.servicios.ContactoServicio;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
public class ContactoControlador {

    private final ContactoServicio contactoServicio;
    private final ContactoMapper contactoMapper;

    public ContactoControlador(ContactoServicio contactoServicio, ContactoMapper contactoMapper) {
        this.contactoServicio = contactoServicio;
        this.contactoMapper = contactoMapper;
    }

    @PostMapping("/api/contactos")
    public ContactoDto crearContacto(@RequestBody ContactoDto contactoDto) {
        ContactoEntity contactoEntity = contactoMapper.mapFrom(contactoDto);
        ContactoEntity crearContactoEntity = contactoServicio.crearContacto(contactoEntity);
        return contactoMapper.mapTo(crearContactoEntity);
    }

    @PutMapping("/api/contactos/{id}")
    public ContactoDto actualizarContacto(@PathVariable Long id, @RequestBody ContactoDto contactoDto) {
        ContactoEntity contactoEntity = contactoMapper.mapFrom(contactoDto);
        contactoEntity.setId(id);
        ContactoEntity actualizarContactoEntity = contactoServicio.actualizarContacto(id, contactoEntity);
        return contactoMapper.mapTo(actualizarContactoEntity);
    }

    @DeleteMapping("/api/contactos/{id}")
    public ResponseEntity<String> eliminarContacto(@PathVariable Long id) {
        boolean eliminado = contactoServicio.eliminarContacto(id);
        if (eliminado) {
            return ResponseEntity.ok("Contacto eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contacto no encontrado");
        }
    }
}
