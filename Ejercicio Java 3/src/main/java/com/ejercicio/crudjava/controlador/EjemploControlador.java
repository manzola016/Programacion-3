package com.ejercicio.crudjava.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EjemploControlador {

    @GetMapping("/ejemplo")
    public String ejemplo() {
        return "Hola mundo";
    }
}
