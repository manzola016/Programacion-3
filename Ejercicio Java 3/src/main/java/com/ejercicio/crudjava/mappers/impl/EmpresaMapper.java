package com.ejercicio.crudjava.mappers.impl;

import com.ejercicio.crudjava.domain.dto.EmpresaDto;
import com.ejercicio.crudjava.domain.entities.EmpresaEntity;
import com.ejercicio.crudjava.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper implements Mapper<EmpresaEntity, EmpresaDto> {
    private final ModelMapper modelMapper;

    public EmpresaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EmpresaDto mapTo(EmpresaEntity empresaEntity) {
        return modelMapper.map(empresaEntity, EmpresaDto.class);
    }

    @Override
    public EmpresaEntity mapFrom(EmpresaDto empresaDto) {
        return modelMapper.map(empresaDto, EmpresaEntity.class);
    }
}