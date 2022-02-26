package com.basis.sgcproject.service.dto.input;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
public class CompetenciaColaboradorDtoIdInput {
    @NotNull
    private Integer competenciaId;
    @NotNull
    private Integer colaboradorId;
}
