package com.example.crudjava.controlador;

import com.example.crudjava.entity.Estudiante;
import com.example.crudjava.service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @GetMapping
    public List<Estudiante> obtenerTodo() {
        return estudianteServicio.obtenerEstudiantes();
    }

    @GetMapping("/{estudianteId}")
    public Optional<Estudiante> obtenerPorId(@PathVariable("estudianteId") Long estudianteId) {
        return estudianteServicio.obtenerEstudiante(estudianteId);
    }

    @PostMapping
    public Estudiante guardarOactualizar(@RequestBody Estudiante estudiante) {
        estudianteServicio.guardarActualizar(estudiante);
        return estudiante;
    }

    @DeleteMapping("/{estudianteId}")
    public void eliminarEstudiante(@PathVariable("estudianteId") Long estudianteId) {
        estudianteServicio.eliminar(estudianteId);
    }
}
