package com.basis.sgcproject.repository;

import com.basis.sgcproject.domain.Categoria;
import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.service.dto.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query("select new " +
            "com.basis.sgcproject.service.dto.DropdownDTO(c.nome, c.id) " +
            "from Categoria c " )
    List<DropdownDTO> showCategorias();
}
