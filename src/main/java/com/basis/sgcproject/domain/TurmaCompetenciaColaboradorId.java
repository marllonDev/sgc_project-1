package com.basis.sgcproject.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class TurmaCompetenciaColaboradorId implements Serializable {
    @Column(name = "id_turma")
    private Integer idTurma;

    @Column(name = "id_competencia")
    private Integer idCompetencia;

    @Column(name = "id_colaborador")
    private Integer idColaborador;
}
