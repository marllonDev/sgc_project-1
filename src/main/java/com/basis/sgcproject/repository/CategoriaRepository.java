package com.basis.sgcproject.repository;

import com.basis.sgcproject.domain.Categoria;
import com.basis.sgcproject.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
