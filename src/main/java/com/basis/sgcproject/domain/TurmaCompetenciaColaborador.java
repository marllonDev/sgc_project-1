package com.basis.sgcproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "turma_competencia_colaborador")
public class TurmaCompetenciaColaborador {
    @EmbeddedId
    TurmaCompetenciaColaboradorId id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_turma", referencedColumnName = "id", insertable = false, updatable = false)
    private TurmaFormacao turma;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_competencia", referencedColumnName = "id", insertable = false, updatable = false)
    private Competencia competencia;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id", insertable = false, updatable = false)
    private Colaborador colaborador;

}
