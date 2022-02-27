package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.service.dto.ListCompetenciaDTO;
import com.basis.sgcproject.service.dto.input.PostCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper {


    @Mapping(source = "categoria.nome", target = "nomeCategoria")
    List<ListCompetenciaDTO> toDto(List<Competencia> competencia);

    @Mapping(target = "categoria.nome", source = "nomeCategoria")
    List<Competencia> toEntity(List<ListCompetenciaDTO> listCompetenciaDTO);

    @Mapping(target = "idCategoria", source = "categoria.id")
    PostCompetenciaDTO dto(Competencia competencia);

    @Mapping(target = "categoria.id", source = "idCategoria")
    Competencia competencia(PostCompetenciaDTO competenciaDTO);

}