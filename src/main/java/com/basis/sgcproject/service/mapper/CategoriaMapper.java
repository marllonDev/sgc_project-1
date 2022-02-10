package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Categoria;
import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.service.dto.CategoriaDTO;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntityMapper<CategoriaDTO, Categoria> {




}