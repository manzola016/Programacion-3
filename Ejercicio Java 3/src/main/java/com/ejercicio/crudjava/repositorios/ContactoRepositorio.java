package com.ejercicio.crudjava.repositorios;

import com.ejercicio.crudjava.domain.entities.ContactoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends CrudRepository<ContactoEntity, Long> {
}
