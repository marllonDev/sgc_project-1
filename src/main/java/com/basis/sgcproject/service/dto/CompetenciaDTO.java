package com.basis.sgcproject.service.dto;

import com.basis.sgcproject.domain.Categoria;
import com.basis.sgcproject.domain.Senioridade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Categoria categoria;


}
