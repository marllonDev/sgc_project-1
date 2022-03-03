package com.basis.sgcproject.repository;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaNivelMaximoListDto;
import com.basis.sgcproject.service.dto.ColaboradorSenioridadeListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query(value = "select cc.colaborador from ColaboradorCompetencia cc join cc.colaborador where cc.id.idCompetencia = :idCompetencia")
    List<Colaborador> buscarColaboradorPorCompetencia(@Param("idCompetencia") Integer idCompetencia);

    @Query(value = "select new com.basis.sgcproject.service.dto.ColaboradorSenioridadeListDTO(c.id, c.nome, c.sobrenome, c.email, c.senioridade.descricao) from Colaborador c")
    List<ColaboradorSenioridadeListDTO> buscarColaboradorPorSenioridade();

    @Query(value = "select new com.basis.sgcproject.service.dto.ColaboradorCompetenciaNivelMaximoListDto(cc.id.idColaborador, cc.colaborador.nome, cc.colaborador.sobrenome, cc.id.idCompetencia, cc.competencia.nome, cc.nivel) from ColaboradorCompetencia cc where cc.nivel = 'SABE_ENSINAR'")
    List<ColaboradorCompetenciaNivelMaximoListDto> buscarColaboradorCompetenciaNivelMaximo();

}
