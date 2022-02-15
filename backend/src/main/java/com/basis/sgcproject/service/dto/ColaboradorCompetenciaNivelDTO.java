package com.basis.sgcproject.service.dto;

import com.basis.sgcproject.domain.Nivel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorCompetenciaNivelDTO implements Serializable {

    private Integer idColaborador;

    private Integer idCompetencia;

    private Nivel nivel;
}
