package com.basis.sgcproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TurmaFormacaoDto {
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private Integer statusId;
    private Set<CompetenciaColaboradorDtoId> competenciasColaboradores = new HashSet<>();
}
