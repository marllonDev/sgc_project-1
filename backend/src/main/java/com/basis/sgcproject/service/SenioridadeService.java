package com.basis.sgcproject.service;

import com.basis.sgcproject.repository.SenioridadeRepository;
import com.basis.sgcproject.service.dto.SenioridadeDTO;
import com.basis.sgcproject.service.mapper.SenioridadeMapper;
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
