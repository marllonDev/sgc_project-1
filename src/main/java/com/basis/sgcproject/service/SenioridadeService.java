package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Competencia;
import com.basis.sgcproject.repository.CategoriaRepository;
import com.basis.sgcproject.repository.CompetenciaRepository;
import com.basis.sgcproject.repository.SenioridadeRepository;
import com.basis.sgcproject.repository.TurmaFormacaoRepository;
import com.basis.sgcproject.service.dto.CategoriaDTO;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import com.basis.sgcproject.service.dto.SenioridadeDTO;
import com.basis.sgcproject.service.mapper.CategoriaMapper;
import com.basis.sgcproject.service.mapper.CompetenciaMapper;
import com.basis.sgcproject.service.mapper.SenioridadeMapper;
import com.basis.sgcproject.service.mapper.TurmaFormacaoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SenioridadeService {
    private final SenioridadeMapper senioridadeMapper;

    private final SenioridadeRepository senioridadeRepository;

    public List<SenioridadeDTO> buscar(){

        return senioridadeMapper.toDto(senioridadeRepository.findAll());
    }
}
