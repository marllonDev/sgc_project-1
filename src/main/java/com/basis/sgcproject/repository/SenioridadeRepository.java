package com.basis.sgcproject.repository;

import com.basis.sgcproject.domain.Senioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenioridadeRepository extends JpaRepository<Senioridade, Integer> {
}