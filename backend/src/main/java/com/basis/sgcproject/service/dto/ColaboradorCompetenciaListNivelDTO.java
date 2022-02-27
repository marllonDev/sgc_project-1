package com.basis.sgcproject.service.dto;

import com.basis.sgcproject.domain.Nivel;
import com.basis.sgcproject.service.dto.input.PostCompetenciaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorCompetenciaListNivelDTO implements Serializable {
    private Integer idColaborador;
    private String nomeDoColaborador;
    private String sobreNomeColaborador;
    private PostCompetenciaDTO competencia;
    private Nivel nivel;
}
