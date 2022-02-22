package com.basis.sgcproject.service;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.exception.RegraNegocioException;
import com.basis.sgcproject.repository.ColaboradorRepository;
import com.basis.sgcproject.service.dto.*;
import com.basis.sgcproject.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    private final ColaboradorMapper colaboradorMapper;


    public List<ColaboradorSenioridadeListDTO> obterTodos(){
        return colaboradorRepository.buscarColaboradorPorSenioridade();
    }

    public ColaboradorDTO salvar(ColaboradorDTO colaboradorDTO){
        if (colaboradorDTO != null && colaboradorDTO.getId() != null) {
            Optional<Colaborador> colaboradorEncontrado = colaboradorRepository.findById(colaboradorDTO.getId());
            if (!colaboradorEncontrado.isPresent()) {
                throw new RegraNegocioException("Colaborador não encontrado para edição");
            }
         }
        return colaboradorMapper.toDto(colaboradorRepository.save(colaboradorMapper.toEntity(colaboradorDTO)));
    }

    public ColaboradorDTO obterPorId(Integer id){
        Optional <Colaborador> colaboradorOP = colaboradorRepository. findById(id);
        colaboradorOP.orElseThrow(() -> new RegraNegocioException("Colaborador não encontrado"));
        return colaboradorMapper.toDto(colaboradorOP.get());
    }

    public void deletar(Integer id) {
        if(!colaboradorRepository.existsById(id)){
            throw new RuntimeException("Esse ID não existe!");
        }
        colaboradorRepository.deleteById(id);
    }

    public List<ColaboradorDTO> findAllColaboradorPorCompetencia(Integer idCompetencia){
        return colaboradorMapper.toDto(colaboradorRepository.buscarColaboradorPorCompetencia(idCompetencia));
    }

    public List<ColaboradorCompetenciaListNivelDTO> buscarColaboradorCompetenciaNivel(){
        return colaboradorRepository.buscarColaboradorCompetenciaNivel();
    }

//    public List<CompetenciaColaboradorNivelMaximoDto> buscarCompetenciaColaboradorNivelMaximo() {
//         return colaboradorRepository.buscarColaboradorCompetenciaNivelMaximo();
//    }
}
