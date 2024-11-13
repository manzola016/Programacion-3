package com.ejercicio.crudjava.mappers.impl;

import com.ejercicio.crudjava.domain.dto.ContactoDto;
import com.ejercicio.crudjava.domain.entities.ContactoEntity;
import com.ejercicio.crudjava.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactoMapper implements Mapper<ContactoEntity, ContactoDto> {
    private ModelMapper modelMapper;

    public ContactoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactoDto mapTo(ContactoEntity contactoEntity) {
        return modelMapper.map(contactoEntity, ContactoDto.class);
    }

    @Override
    public ContactoEntity mapFrom(ContactoDto contactoDto) {
        return modelMapper.map(contactoDto, ContactoEntity.class);
    }
}
