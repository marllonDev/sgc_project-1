package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.domain.ColaboradorCompetencia;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import org.mapstruct.*;

@Mapper(componentModel = "Spring", uses = ColaboradorCompetenciaMapper.class)
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador>{

    @Override
    @Mapping(source = "senioridade.id", target = "senioridadeID")
    ColaboradorDTO toDto(Colaborador colaborador);

    @Override
    @Mapping(source = "senioridadeID", target = "senioridade.id")
    Colaborador toEntity (ColaboradorDTO colaboradorDTO);

    @AfterMapping
    default void mapearRelacionamento(@MappingTarget Colaborador colaborador){
        colaborador.getColaboradorCompetencias().stream().forEach(colaboradorCompetencia -> {
            colaboradorCompetencia.getId().setIdColaborador(colaborador.getId());
            colaboradorCompetencia.setColaborador(colaborador);
            colaboradorCompetencia.getId().setIdCompetencia(colaboradorCompetencia.getCompetencia().getId());
        });
    }
}
