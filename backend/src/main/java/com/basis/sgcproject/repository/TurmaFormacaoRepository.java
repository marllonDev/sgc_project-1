package com.basis.sgcproject.repository;

import com.basis.sgcproject.domain.TurmaFormacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaFormacaoRepository extends JpaRepository<TurmaFormacao, Integer> {
    TurmaFormacao findByStatusId(Integer statusId);
}
