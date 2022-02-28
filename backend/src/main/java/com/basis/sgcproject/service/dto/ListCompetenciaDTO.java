package com.basis.sgcproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListCompetenciaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private String nomeCategoria;

    public ListCompetenciaDTO(Integer id, String nome, String descricao, String nomeCategoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeCategoria = nomeCategoria;
    }
}
