package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.repository.CompetenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaCompetenciaService {

    private final CompetenciaRepository competenciaRepository;

    public void removerCategoriasDeCompetecias(Integer colaboradorId){
        competenciaRepository.flush();
        List<Competencia> lista = competenciaRepository.findAllByCategoriaId(colaboradorId);
        if (lista.isEmpty()){
            return;
        }
        lista.forEach(competenciaRepository::delete);
    }
}
