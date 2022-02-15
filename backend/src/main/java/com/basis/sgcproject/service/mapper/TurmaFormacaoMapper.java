package com.basis.sgcproject.service.mapper;

import com.basis.sgcproject.domain.TurmaCompetenciaColaborador;
import com.basis.sgcproject.domain.TurmaFormacao;
import com.basis.sgcproject.service.dto.CompetenciaColaboradorDtoId;
import com.basis.sgcproject.service.dto.TurmaFormacaoDto;
import liquibase.pro.packaged.M;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper extends EntityMapper<TurmaFormacaoDto, TurmaFormacao> {
    @Override
    @Mapping(source = "status.id", target = "statusId")
    TurmaFormacaoDto toDto(TurmaFormacao turmaFormacao);

    @Override
    @Mapping(source = "status.id", target = "statusId")
    List<TurmaFormacaoDto> toDto(List<TurmaFormacao> turmas);

    @Override
    @Mapping(source = "statusId", target = "status.id")
    TurmaFormacao toEntity(TurmaFormacaoDto turmaFormacaoDto);

    @Mapping(source = "competenciaId", target = "id.idCompetencia")
    @Mapping(source = "colaboradorId", target = "id.idColaborador")
    TurmaCompetenciaColaborador toCompColabEntity(CompetenciaColaboradorDtoId compColabDto);

    @Mapping(source = "id.idCompetencia", target = "competenciaId")
    @Mapping(source = "id.idColaborador", target = "colaboradorId")
    CompetenciaColaboradorDtoId toCompColabDto(TurmaCompetenciaColaborador compColab);
}
