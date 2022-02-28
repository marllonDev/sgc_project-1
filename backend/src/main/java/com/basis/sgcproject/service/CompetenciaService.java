package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.repository.CompetenciaRepository;
import com.basis.sgcproject.service.dto.CategoriaDTO;
import com.basis.sgcproject.service.dto.ListCompetenciaDTO;
import com.basis.sgcproject.service.dto.input.PostCompetenciaDTO;
import com.basis.sgcproject.service.mapper.CategoriaMapper;
import com.basis.sgcproject.service.mapper.CompetenciaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;
    private final CategoriaMapper categoriaMapper;

    public List<ListCompetenciaDTO> buscar(){

        return competenciaRepository.mostrar();


    }

    public PostCompetenciaDTO salvar(PostCompetenciaDTO dto){

        Competencia competencia = competenciaMapper.competencia(dto);
        return competenciaMapper.dto(competenciaRepository.save(competencia));

    }

    public PostCompetenciaDTO buscarPorId(Integer id){

        Competencia competencia = competenciaRepository.findById(id).orElseThrow(()->new RuntimeException("Competencia não encontrada!"));

        return competenciaMapper.dto(competencia);

    }


    public void deletar(Integer id){

        competenciaRepository.deleteById(id);

    }

    public List<ListCompetenciaDTO> findAllByCategoriaId(Integer categoriaId){
        return competenciaMapper.toDto(competenciaRepository.findAllByCategoriaId(categoriaId));
    }


}