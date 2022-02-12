package com.basis.sgcproject.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Table(name = "turma_competencia_colaborador")
public class TurmaCompetenciaColaborador {
    @EmbeddedId
    TurmaCompetenciaColaboradorId id;

    @MapsId("idTurma")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_turma", referencedColumnName = "id", insertable = false, updatable = false)
    private TurmaFormacao turma;

    @MapsId("idCompetencia")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_competencia", referencedColumnName = "id", insertable = false, updatable = false)
    private Competencia competencia;

    @MapsId("idColaborador")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id", insertable = false, updatable = false)
    private Colaborador colaborador;

}
