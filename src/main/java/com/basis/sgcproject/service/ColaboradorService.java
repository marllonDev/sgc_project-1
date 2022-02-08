package com.basis.sgcproject.service;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.repository.ColaboradorRepository;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import com.basis.sgcproject.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {
//variável pegando do ColaboradorRepository
    private final ColaboradorRepository colaboradorRepository;
//variável pegando do ColaboradorMapper
    private final ColaboradorMapper colaboradorMapper;
//criando list de colaboradorDTO

//método obterTodos
    public List<ColaboradorDTO> obterTodos(){
        return colaboradorMapper.toDto(colaboradorRepository.findAll());
    }
//método salvar
    public ColaboradorDTO salvar(ColaboradorDTO colaboradorDTO){
        if (colaboradorDTO != null && colaboradorDTO.getId() != null){
            Optional<Colaborador> colaboradorEncontrado = colaboradorRepository.findById(colaboradorDTO.getId());
            if (!colaboradorEncontrado.isPresent()){
                throw new RuntimeException("Colaborador não encontrado para edição");
            }
        }
        Colaborador colaborador = new Colaborador();//instanciando um objeto
        colaborador = colaboradorMapper.toEntity(colaboradorDTO);
        colaborador = colaboradorRepository.save(colaborador);
        return colaboradorMapper.toDto(colaborador);
    }
//método obterPorId
    public ColaboradorDTO obterPorId(Integer id){
        Optional <Colaborador> colaboradorOP = colaboradorRepository.findById(id);
        if (!colaboradorOP.isPresent()){
            return null;
        }
        Colaborador colaborador = colaboradorOP.get();
        ColaboradorDTO colaboradorDTO = colaboradorMapper.toDto(colaborador);
        return colaboradorDTO;
    }

    public void deletar(Integer id){
        colaboradorRepository.deleteById(id);
    }
}
