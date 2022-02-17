package com.basis.sgcproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TurmaFormacaoDto {
    private Integer id;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;
    @NotNull
    private LocalDateTime dataInicio;
    @NotNull
    private LocalDateTime dataTermino;
    @NotNull
    private StatusDTO status;
    @Valid
    @NotEmpty(message = "Obrigatório informar ao menos uma compentência")
    private Set<CompetenciaColaboradorDtoId> competenciasColaboradores = new HashSet<>();
}
