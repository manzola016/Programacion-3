package com.example.crudjava.service;

import com.example.crudjava.entity.Estudiante;
import com.example.crudjava.repository.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {
    @Autowired
    EstudianteRepositorio estudianteRepositorio;

    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    public Optional<Estudiante> obtenerEstudiante(Long id) {
        return estudianteRepositorio.findById(id);
    }

    public void guardarActualizar(Estudiante estudiante) {
        estudianteRepositorio.save(estudiante);
    }

    public void eliminar(Long id) {
        estudianteRepositorio.deleteById(id);
    }
}
