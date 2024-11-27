package com.ejercicio.crudjava.repositorios;

import com.ejercicio.crudjava.domain.entities.EmpresaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends CrudRepository<EmpresaEntity, Long> {
}