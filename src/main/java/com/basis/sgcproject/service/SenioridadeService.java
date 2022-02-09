package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Senioridade;
import com.basis.sgcproject.repository.SenioridadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SenioridadeService {

    private final SenioridadeRepository senioridadeRepository;

    public List<Senioridade>listarTodas(){

        return senioridadeRepository.findAll();
    }
    public Senioridade buscarId(Integer id){
        Optional<Senioridade> obj = senioridadeRepository.findById(id);
        return obj.get();
    }



}
