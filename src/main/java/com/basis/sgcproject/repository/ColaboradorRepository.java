package com.basis.sgcproject.repository;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query(value = "select cc.colaborador from ColaboradorCompetencia cc join cc.colaborador where cc.id.idCompetencia = :idCompetencia")
    List<Colaborador> buscarColaboradorPorCompetencia(@Param("idCompetencia") Integer idCompetencia);



    @Query(value = "select new com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO(cc.id.idColaborador, cc.colaborador.nome, cc.id.idCompetencia, cc.competencia.nome, cc.nivel) from ColaboradorCompetencia cc ")
    List<ColaboradorCompetenciaListNivelDTO> buscarColaboradorCompetenciaNivel();

}
