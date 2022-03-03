package com.basis.sgcproject.service.dto;

import com.basis.sgcproject.domain.Nivel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorCompetenciaNivelMaximoListDto {
    private Integer idColaborador;
    private String nomeDoColaborador;
    private String sobreNomeColaborador;
    private Integer idCompetencia;
    private String nomeCompetencia;
    private Nivel nivel;
}
