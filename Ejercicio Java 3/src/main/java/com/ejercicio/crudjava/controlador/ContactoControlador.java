package com.ejercicio.crudjava.controlador;

import com.ejercicio.crudjava.modelo.Contacto;
import com.ejercicio.crudjava.servicio.ContactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacto")
public class ContactoControlador {
    private final ContactoServicio contactoServicio;

    @Autowired
    public ContactoControlador(ContactoServicio contactoServicio) {
        this.contactoServicio = contactoServicio;
    }

    @GetMapping
    public List<Contacto> obtenerContactos() {
        return contactoServicio.obtenerContactos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> obtenerContactoPorId(@PathVariable Long id) {
        Optional<Contacto> contacto = contactoServicio.obtenerContactoPorId(id);
        return contacto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contacto crearContacto(@RequestBody Contacto contacto) {
        return contactoServicio.crearContacto(contacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contacto> actualizarContacto(@PathVariable Long id, @RequestBody Contacto contactoDetalles) {
        Optional<Contacto> contacto = contactoServicio.actualizarContacto(id, contactoDetalles);
        return contacto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable Long id) {
        if (contactoServicio.eliminarContacto(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
