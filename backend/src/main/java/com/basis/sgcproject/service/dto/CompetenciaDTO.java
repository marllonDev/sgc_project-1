package com.basis.sgcproject.service.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompetenciaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private CategoriaDTO categoriaDTO;


}
