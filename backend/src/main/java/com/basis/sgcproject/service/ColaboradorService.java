package com.basis.sgcproject.service;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.exception.RegraNegocioException;
import com.basis.sgcproject.repository.ColaboradorCompetenciaRepository;
import com.basis.sgcproject.repository.ColaboradorRepository;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import com.basis.sgcproject.service.dto.ColaboradorSenioridadeListDTO;
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

    private final ColaboradorRepository colaboradorRepository;

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorCompetenciaService colaboradorCompetenciaService;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;


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
        Optional <Colaborador> colaboradorOP = colaboradorRepository.findById(id);
        colaboradorOP.orElseThrow(() -> new RegraNegocioException("Colaborador não encontrado"));
        return colaboradorMapper.toDto(colaboradorOP.get());
    }

    public void deletar(Integer id) {
        if (!colaboradorRepository.existsById(id)) {
            throw new RuntimeException("Esse ID não existe!");
        }
        removerCompetenciasColaborador(id);
        colaboradorRepository.deleteById(id);
//        }else if (colaboradorCompetenciaRepository.findAllByColaboradorId(id) != null){
//        removerCompetenciasColaborador(id);
//        }
    }

    public void removerCompetenciasColaborador(Integer idColaborador){
        colaboradorCompetenciaService.removerCompetenciasColaborador(idColaborador);
    }

    public List<ColaboradorDTO> findAllColaboradorPorCompetencia(Integer idCompetencia){
        return colaboradorMapper.toDto(colaboradorRepository.buscarColaboradorPorCompetencia(idCompetencia));
    }

    public List<ColaboradorCompetenciaListNivelDTO> buscarColaboradorCompetenciaNivel(){
        return colaboradorRepository.buscarColaboradorCompetenciaNivel();
    }
}
