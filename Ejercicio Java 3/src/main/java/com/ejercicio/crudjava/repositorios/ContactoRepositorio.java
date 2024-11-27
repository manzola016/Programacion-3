package com.ejercicio.crudjava.repositorios;

import com.ejercicio.crudjava.domain.entities.ContactoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepositorio extends CrudRepository<ContactoEntity, Long> {

    @Query("SELECT c FROM ContactoEntity c LEFT JOIN FETCH c.relaciones r LEFT JOIN FETCH r.empresa")
    List<ContactoEntity> findAllWithRelations();

}