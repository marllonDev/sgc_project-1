package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.repository.CompetenciaRepository;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import com.basis.sgcproject.service.mapper.CompetenciaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;

    public List<CompetenciaDTO> buscar(){
        List<Competencia> competencia = competenciaRepository.findAll();
        return competenciaMapper.toDto(competencia);

    }

    public CompetenciaDTO salvar(CompetenciaDTO dto){

        Competencia competencia = competenciaMapper.toEntity((dto));
        return competenciaMapper.toDto(competenciaRepository.save(competencia));

    }

    public CompetenciaDTO buscarPorId(Integer id){

        Competencia competencia = competenciaRepository.findById(id).orElseThrow(()->new RuntimeException("Competencia não encontrada!"));

        return competenciaMapper.toDto(competencia);

    }


    public void deletar(Integer id){

        competenciaRepository.deleteById(id);

    }


}