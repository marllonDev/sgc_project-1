package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.ColaboradorCompetencia;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaNivelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses =CompetenciaMapper.class)
public interface ColaboradorCompetenciaMapper {

    @Mapping(source = "id.idColaborador", target = "idColaborador")
    @Mapping(source = "colaborador.nome", target = "nomeDoColaborador")
    ColaboradorCompetenciaListNivelDTO toDto(ColaboradorCompetencia colaboradorCompetencia);

    List<ColaboradorCompetenciaListNivelDTO> toDto(List<ColaboradorCompetencia> colaboradorCompetencia);

    @Mapping(target = "id.idColaborador", source = "idColaborador")
    @Mapping(target = "colaborador.nome", source = "nomeDoColaborador")
    @Mapping(target = "id.idCompetencia", source = "competencia.id")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaListNivelDTO colaboradorCompetenciaDto);

    @Mapping(target = "id.idColaborador", source = "idColaborador")
    @Mapping(target = "id.idCompetencia", source = "idCompetencia")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaNivelDTO colaboradorCompetenciaDto);

    List<ColaboradorCompetencia> toEntity(List<ColaboradorCompetenciaListNivelDTO> competencias);
}