package com.basis.sgcproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompetenciaColaboradorNivelMaximoDto {
    private CompetenciaResumoDto competencia;
    private List<ColaboradorResumoDto> colaboradores = new ArrayList<>();
}
