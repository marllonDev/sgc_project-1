package com.basis.sgcproject.service;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.exception.RegraNegocioException;
import com.basis.sgcproject.repository.ColaboradorCompetenciaRepository;
import com.basis.sgcproject.repository.ColaboradorRepository;
import com.basis.sgcproject.service.dto.*;
import com.basis.sgcproject.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorCompetenciaService colaboradorCompetenciaService;



    public List<ColaboradorSenioridadeListDTO> obterTodos() {
        return colaboradorRepository.buscarColaboradorPorSenioridade();
    }

    public ColaboradorDTO salvar(ColaboradorDTO colaboradorDTO) {
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
    }

    public void removerCompetenciasColaborador(Integer idColaborador){
        colaboradorCompetenciaService.removerCompetenciasColaborador(idColaborador);
    }

    public List<ColaboradorDTO> findAllColaboradorPorCompetencia(Integer idCompetencia) {
        return colaboradorMapper.toDto(colaboradorRepository.buscarColaboradorPorCompetencia(idCompetencia));
    }

    public List<ColaboradorCompetenciaListNivelDTO> buscarColaboradorCompetenciaNivel() {
        return colaboradorCompetenciaService.buscarColaboradorCompetenciaMaiorNivel();
    }

    public List<CompetenciaColaboradorNivelMaximoDto> buscarCompetenciaColaboradorNivelMaximo() {
        List<ColaboradorCompetenciaNivelMaximoListDto> resultQuery = colaboradorRepository.buscarColaboradorCompetenciaNivelMaximo();
        Map<Integer, CompetenciaColaboradorNivelMaximoDto> map = new HashMap<>();

        for (ColaboradorCompetenciaNivelMaximoListDto colaboradorCompetenciaResultQuery : resultQuery) {
            CompetenciaColaboradorNivelMaximoDto competenciaKey = map.computeIfAbsent(colaboradorCompetenciaResultQuery.getIdCompetencia(), (k) -> {
                CompetenciaColaboradorNivelMaximoDto competencia = new CompetenciaColaboradorNivelMaximoDto();
                competencia.setCompetencia(new CompetenciaResumoDto());
                competencia.getCompetencia().setId(colaboradorCompetenciaResultQuery.getIdCompetencia());
                competencia.getCompetencia().setNome(colaboradorCompetenciaResultQuery.getNomeCompetencia());
                return competencia;
            });
            ColaboradorResumoDto colaborador = new ColaboradorResumoDto();
            colaborador.setId(colaboradorCompetenciaResultQuery.getIdColaborador());
            colaborador.setNome(colaboradorCompetenciaResultQuery.getNomeDoColaborador());
            colaborador.setSobrenome(colaboradorCompetenciaResultQuery.getSobreNomeColaborador());
            competenciaKey.getColaboradores().add(colaborador);
        }
        return new ArrayList<>(map.values());
    }
}
