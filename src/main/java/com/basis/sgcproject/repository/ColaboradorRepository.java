package com.basis.sgcproject.repository;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

//    @Query(value = "select from Colaborador c join ColaboradorCopetencia ct on c.id = ct.id_competencia")
//    public List<Colaborador> find(String competencia){

}
