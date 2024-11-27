package com.ejercicio.crudjava.servicios;

import com.ejercicio.crudjava.domain.entities.EmpresaEntity;

import java.util.List;

public interface EmpresaServicio {

    List<EmpresaEntity> obtenerEmpresas();

    EmpresaEntity crearEmpresa(EmpresaEntity empresaEntity);

    EmpresaEntity actualizarEmpresa(Long id, EmpresaEntity empresaEntity);

    boolean eliminarEmpresa(Long id);

}