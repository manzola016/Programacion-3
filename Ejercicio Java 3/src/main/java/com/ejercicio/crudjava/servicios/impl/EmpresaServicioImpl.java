package com.ejercicio.crudjava.servicios.impl;

import com.ejercicio.crudjava.domain.entities.EmpresaEntity;
import com.ejercicio.crudjava.repositorios.EmpresaRepositorio;
import com.ejercicio.crudjava.servicios.EmpresaServicio;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class EmpresaServicioImpl implements EmpresaServicio {
    private final EmpresaRepositorio empresaRepositorio;

    public EmpresaServicioImpl(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    @Override
    public List<EmpresaEntity> obtenerEmpresas() {
        return (List<EmpresaEntity>) empresaRepositorio.findAll();
    }

    @Override
    public EmpresaEntity crearEmpresa(EmpresaEntity empresaEntity) {
        return empresaRepositorio.save(empresaEntity);
    }

    @Override
    public EmpresaEntity actualizarEmpresa(Long id, EmpresaEntity empresaEntity) {
        if (empresaRepositorio.existsById(id)) {
            empresaEntity.setId(id);
            return empresaRepositorio.save(empresaEntity);
        } else {
            log.warning("Empresa con ID " + id + " no encontrada");
            return null;
        }
    }

    @Override
    public boolean eliminarEmpresa(Long id) {
        if (empresaRepositorio.existsById(id)) {
            empresaRepositorio.deleteById(id);
            return true;
        } else {
            log.warning("Empresa con ID " + id + " no encontrada");
            return false;
        }
    }
}