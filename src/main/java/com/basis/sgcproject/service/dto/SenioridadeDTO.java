package com.basis.sgcproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class SenioridadeDTO {
    @NotNull
    private Integer id;
    @NotNull
    private String descricao;
}
