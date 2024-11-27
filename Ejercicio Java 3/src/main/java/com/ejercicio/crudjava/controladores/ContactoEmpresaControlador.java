package com.ejercicio.crudjava.controladores;

import com.ejercicio.crudjava.domain.dto.ContactoEmpresaDto;
import com.ejercicio.crudjava.domain.entities.ContactoEmpresaEntity;
import com.ejercicio.crudjava.mappers.impl.ContactoEmpresaMapper;
import com.ejercicio.crudjava.servicios.ContactoEmpresaServicio;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log
public class ContactoEmpresaControlador {

    private final ContactoEmpresaServicio contactoEmpresaServicio;
    private final ContactoEmpresaMapper contactoEmpresaMapper;

    public ContactoEmpresaControlador(ContactoEmpresaServicio contactoEmpresaServicio, ContactoEmpresaMapper contactoEmpresaMapper) {
        this.contactoEmpresaServicio = contactoEmpresaServicio;
        this.contactoEmpresaMapper = contactoEmpresaMapper;
    }

    @GetMapping("/api/contacto-empresa")
    public List<ContactoEmpresaDto> listarRelaciones() {
        List<ContactoEmpresaEntity> relaciones = contactoEmpresaServicio.obtenerRelaciones();
        return relaciones.stream().map(contactoEmpresaMapper::mapTo).collect(Collectors.toList());
    }

    @PostMapping("/api/contacto-empresa")
    public ContactoEmpresaDto crearRelacion(@RequestBody ContactoEmpresaDto contactoEmpresaDto) {
        ContactoEmpresaEntity contactoEmpresaEntity = contactoEmpresaMapper.mapFrom(contactoEmpresaDto);
        ContactoEmpresaEntity nuevaRelacion = contactoEmpresaServicio.crearRelacion(contactoEmpresaEntity);
        return contactoEmpresaMapper.mapTo(nuevaRelacion);
    }

    @DeleteMapping("/api/contacto-empresa/{id}")
    public ResponseEntity<String> eliminarRelacion(@PathVariable Long id) {
        boolean eliminado = contactoEmpresaServicio.eliminarRelacion(id);
        if (eliminado) {
            return ResponseEntity.ok("Relacion eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relacion no encontrada");
        }
    }
}