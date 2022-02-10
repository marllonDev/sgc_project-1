package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia> {

    @Override
    @Mapping(source = "categoria.id", target = "idCategoria")
    CompetenciaDTO toDto(Competencia competencia);

    @Override
    @Mapping(target = "categoria.id", source = "idCategoria")
    Competencia toEntity(CompetenciaDTO competenciaDTO);

}