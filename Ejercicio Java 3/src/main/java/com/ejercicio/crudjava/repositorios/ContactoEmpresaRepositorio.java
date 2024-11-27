package com.ejercicio.crudjava.repositorios;

import com.ejercicio.crudjava.domain.entities.ContactoEmpresaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoEmpresaRepositorio extends CrudRepository<ContactoEmpresaEntity, Long> {
}