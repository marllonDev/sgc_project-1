package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Categoria;
import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.domain.ColaboradorCompetencia;
import com.basis.sgcproject.service.dto.CategoriaDTO;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorCompetenciaMapper {

    @Mapping(source = "id.idColaborador", target = "idColaborador")
    @Mapping(source = "colaborador.nome", target = "nomeDoColaborador")
    @Mapping(source = "id.idCompetencia", target = "idCompetencia")
    @Mapping(source = "competencia.nome", target = "nomeCompetencia")
    ColaboradorCompetenciaListNivelDTO toDto(ColaboradorCompetencia colaboradorCompetencia);

    List<ColaboradorCompetenciaListNivelDTO> toDto(List<ColaboradorCompetencia> colaboradorCompetencia);

    @Mapping(target = "id.idColaborador", source = "idColaborador")
    @Mapping(target = "colaborador.nome", source = "nomeDoColaborador")
    @Mapping(target = "id.idCompetencia", source = "idCompetencia")
    @Mapping(target = "competencia.nome", source = "nomeCompetencia")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaListNivelDTO colaboradorCompetenciaDto);

    @Mapping(target = "id.idColaborador", source = "idColaborador")
    @Mapping(target = "id.idCompetencia", source = "idCompetencia")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaNivelDTO colaboradorCompetenciaDto);
}