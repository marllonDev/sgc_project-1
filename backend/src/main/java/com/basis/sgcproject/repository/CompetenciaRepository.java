package com.basis.sgcproject.repository;

import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

    List<Competencia> findAllByCategoriaId(Integer categoriaId);
}