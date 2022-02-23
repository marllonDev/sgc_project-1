package com.basis.sgcproject.repository;

import com.basis.sgcproject.domain.ColaboradorCompetencia;
import com.basis.sgcproject.domain.ColaboradorCompetenciaID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaID> {

    @Query(value = "select cc from ColaboradorCompetencia cc join cc.colaborador c where c.id = :idColaborador")
    List buscarPorId(@Param("idColaborador") Integer colaboradorId);

    void deleteAllByColaboradorId(Integer colaboradorid);
}
