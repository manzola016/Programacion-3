package com.ejercicio.crudjava.mappers.impl;

import com.ejercicio.crudjava.domain.dto.ContactoEmpresaDto;
import com.ejercicio.crudjava.domain.entities.ContactoEmpresaEntity;
import com.ejercicio.crudjava.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactoEmpresaMapper implements Mapper<ContactoEmpresaEntity, ContactoEmpresaDto> {
    private final ModelMapper modelMapper;

    public ContactoEmpresaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactoEmpresaDto mapTo(ContactoEmpresaEntity contactoEmpresaEntity) {
        return modelMapper.map(contactoEmpresaEntity, ContactoEmpresaDto.class);
    }

    @Override
    public ContactoEmpresaEntity mapFrom(ContactoEmpresaDto contactoEmpresaDto) {
        return modelMapper.map(contactoEmpresaDto, ContactoEmpresaEntity.class);
    }
}