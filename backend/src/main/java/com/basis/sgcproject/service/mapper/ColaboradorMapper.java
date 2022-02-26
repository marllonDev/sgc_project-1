package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador>{

    @Override
    @Mapping(source = "senioridade.id", target = "senioridadeID")
    ColaboradorDTO toDto(Colaborador colaborador);

    @Override
    @Mapping(source = "senioridadeID", target = "senioridade.id")
    Colaborador toEntity (ColaboradorDTO colaboradorDTO);


}
