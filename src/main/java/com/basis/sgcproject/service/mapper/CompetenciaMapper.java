package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia> {




}