package com.basis.sgcproject.service.mapper;

import com.basis.sgcproject.domain.TurmaCompetenciaColaborador;
import com.basis.sgcproject.domain.TurmaFormacao;
import com.basis.sgcproject.service.dto.CompetenciaColaboradorDto;
import com.basis.sgcproject.service.dto.input.CompetenciaColaboradorDtoIdInput;
import com.basis.sgcproject.service.dto.TurmaFormacaoDto;
import com.basis.sgcproject.service.dto.input.TurmaFormacaoDtoInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper {

    @Mapping(source = "status.id", target = "status.id")
    @Mapping(source = "status.descricao", target = "status.descricao")
    TurmaFormacaoDto toDto(TurmaFormacao turmaFormacao);

    @Mapping(source = "status.id", target = "status.id")
    @Mapping(source = "status.descricao", target = "status.descricao")
    List<TurmaFormacaoDto> toDto(List<TurmaFormacao> turmas);

    @Mapping(source = "statusId", target = "status.id")
    TurmaFormacao toEntity(TurmaFormacaoDtoInput turmaFormacaoDtoInput);

    @Mapping(source = "competenciaId", target = "id.idCompetencia")
    @Mapping(source = "colaboradorId", target = "id.idColaborador")
    TurmaCompetenciaColaborador toCompColabEntity(CompetenciaColaboradorDtoIdInput compColabDtoIdInput);

    @Mapping(source = "id.idCompetencia", target = "competencia.id")
    @Mapping(source = "competencia.nome", target = "competencia.nome")
    @Mapping(source = "id.idColaborador", target = "colaborador.id")
    @Mapping(source = "colaborador.nome", target = "colaborador.nome")
    CompetenciaColaboradorDto toCompColabDto(TurmaCompetenciaColaborador compColab);
}
