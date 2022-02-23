package com.basis.sgcproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ColaboradorCompetenciaID implements Serializable {

    @Column(name = "id_colaborador", nullable = false)
    private Integer idColaborador;

    @Column(name = "id_competencia", nullable = false)
    private Integer idCompetencia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColaboradorCompetenciaID that = (ColaboradorCompetenciaID) o;
        return idColaborador.equals(that.idColaborador) && idCompetencia.equals(that.idCompetencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idColaborador, idCompetencia);
    }
}
