package com.basis.sgcproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colaborador_competencia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ColaboradorCompetencia implements Serializable {
    @EmbeddedId
    private ColaboradorCompetenciaID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id", insertable = false, updatable = false)
    private Colaborador colaborador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_competencia", referencedColumnName = "id",insertable = false, updatable = false )
    private Competencia competencia;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "nivel")
    private Nivel nivel;
}
