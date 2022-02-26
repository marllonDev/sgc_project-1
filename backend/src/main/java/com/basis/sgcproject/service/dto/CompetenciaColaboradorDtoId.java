package com.basis.sgcproject.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
public class CompetenciaColaboradorDtoId {
    @NotNull
    private Integer competenciaId;
    @NotNull
    private Integer colaboradorId;
}
