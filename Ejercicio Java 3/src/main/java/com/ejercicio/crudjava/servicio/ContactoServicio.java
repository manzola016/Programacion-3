package com.ejercicio.crudjava.servicio;

import com.ejercicio.crudjava.modelo.Contacto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactoServicio {
    private List<Contacto> contactos = new ArrayList<>();
    private Long siguienteId = 1L;

    public List<Contacto> obtenerContactos() {
        return contactos;
    }

    public Optional<Contacto> obtenerContactoPorId(Long id) {
        return contactos.stream().filter(contacto -> contacto.getId().equals(id)).findFirst();
    }

    public Contacto crearContacto(Contacto contacto) {
        contacto.setId(siguienteId++);
        contactos.add(contacto);
        return contacto;
    }

    public Optional<Contacto> actualizarContacto(Long id, Contacto contactoDetalles) {
        return obtenerContactoPorId(id).map(contacto -> {
        contacto.setNombre(contactoDetalles.getNombre());
        contacto.setApellido(contactoDetalles.getApellido());
        contacto.setTelefono(contactoDetalles.getTelefono());
        return contacto;
        });
    }

    public boolean eliminarContacto(Long id) {
        return contactos.removeIf(contacto -> contacto.getId().equals(id));
    }
}
