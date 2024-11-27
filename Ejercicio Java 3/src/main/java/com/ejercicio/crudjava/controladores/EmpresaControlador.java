package com.ejercicio.crudjava.controladores;

import com.ejercicio.crudjava.domain.dto.EmpresaDto;
import com.ejercicio.crudjava.domain.entities.EmpresaEntity;
import com.ejercicio.crudjava.mappers.impl.EmpresaMapper;
import com.ejercicio.crudjava.servicios.EmpresaServicio;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log
public class EmpresaControlador {

    private final EmpresaServicio empresaServicio;
    private final EmpresaMapper empresaMapper;

    public EmpresaControlador(EmpresaServicio empresaServicio, EmpresaMapper empresaMapper) {
        this.empresaServicio = empresaServicio;
        this.empresaMapper = empresaMapper;
    }

    @GetMapping("/api/empresas")
    public List<EmpresaDto> mostrarEmpresas() {
        List<EmpresaEntity> empresas = empresaServicio.obtenerEmpresas();
        return empresas.stream().map(empresaMapper::mapTo).collect(Collectors.toList());
    }

    @PostMapping("/api/empresas")
    public EmpresaDto crearEmpresa(@RequestBody EmpresaDto empresaDto) {
        EmpresaEntity empresaEntity = empresaMapper.mapFrom(empresaDto);
        EmpresaEntity crearEmpresaEntity = empresaServicio.crearEmpresa(empresaEntity);
        return empresaMapper.mapTo(crearEmpresaEntity);
    }

    @PutMapping("/api/empresas/{id}")
    public EmpresaDto actualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaDto empresaDto) {
        EmpresaEntity empresaEntity = empresaMapper.mapFrom(empresaDto);
        empresaEntity.setId(id);
        EmpresaEntity actualizarEmpresaEntity = empresaServicio.actualizarEmpresa(id, empresaEntity);
        return empresaMapper.mapTo(actualizarEmpresaEntity);
    }

    @DeleteMapping("/api/empresas/{id}")
    public ResponseEntity<String> eliminarEmpresa(@PathVariable Long id) {
        boolean eliminado = empresaServicio.eliminarEmpresa(id);
        if (eliminado) {
            return ResponseEntity.ok("Empresa eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada");
        }
    }
}