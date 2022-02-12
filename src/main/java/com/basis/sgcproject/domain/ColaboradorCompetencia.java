package com.basis.sgcproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ColaboradorCompetencia")
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

    @Column(name = "nivel")
    @Enumerated(value = EnumType.ORDINAL)
    private NivelColaboradorCompetenciaEnum nivel;

}
