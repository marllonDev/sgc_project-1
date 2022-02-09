package com.basis.sgcproject.service.mapper;

import com.basis.sgcproject.domain.TurmaFormacao;
import com.basis.sgcproject.service.dto.TurmaFormacaoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper extends EntityMapper<TurmaFormacaoDto, TurmaFormacao> {
    @Override
    @Mapping(source = "status.id", target = "statusId")
    TurmaFormacaoDto toDto(TurmaFormacao turmaFormacao);

    @Override
    List<TurmaFormacaoDto> toDto(List<TurmaFormacao> turmas);

    @Override
    @Mapping(source = "statusId", target = "status.id")
    TurmaFormacao toEntity(TurmaFormacaoDto turmaFormacaoDto);
}
