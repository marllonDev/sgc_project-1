package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.ColaboradorCompetencia;
import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.repository.ColaboradorCompetenciaRepository;
import com.basis.sgcproject.repository.CompetenciaRepository;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaNivelDTO;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import com.basis.sgcproject.service.mapper.ColaboradorCompetenciaMapper;
import com.basis.sgcproject.service.mapper.CompetenciaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColaboradorCompetenciaService {

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;
    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;


    public List<ColaboradorCompetenciaListNivelDTO> buscar(){
        List<ColaboradorCompetencia> competencia = colaboradorCompetenciaRepository.findAll();
        return colaboradorCompetenciaMapper.toDto(competencia);

    }

    public ColaboradorCompetenciaListNivelDTO salvar(ColaboradorCompetenciaNivelDTO dto){
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaMapper.toEntity(dto);
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetenciaRepository.save(colaboradorCompetencia));
    }
}