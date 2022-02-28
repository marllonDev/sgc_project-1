package com.basis.sgcproject.service.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCompetenciaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer idCategoria;


}
