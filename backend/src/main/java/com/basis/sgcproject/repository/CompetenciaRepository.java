package com.basis.sgcproject.repository;

import com.basis.sgcproject.domain.Competencia;

import com.basis.sgcproject.service.dto.ListCompetenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

    @Query("select new " +
            "com.basis.sgcproject.service.dto.ListCompetenciaDTO(c.id, c.nome, c.descricao, ca.nome) " +
            "from Competencia c join c.categoria ca")
    public List<ListCompetenciaDTO> mostrar();

    List<Competencia> findAllByCategoriaId(Integer categoriaId);
}