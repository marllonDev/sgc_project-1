package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.domain.TurmaFormacao;
import com.basis.sgcproject.exception.EntidadeNaoEncontradaException;
import com.basis.sgcproject.exception.RegraNegocioException;
import com.basis.sgcproject.repository.TurmaFormacaoRepository;
import com.basis.sgcproject.service.dto.TurmaFormacaoDto;
import com.basis.sgcproject.service.mapper.TurmaFormacaoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaFormacaoService {

    TurmaFormacaoRepository turmaFormacaoRepository;
    TurmaFormacaoMapper turmaFormacaoMapper;
    StatusService statusService;

    public List<TurmaFormacaoDto> listarTodas() {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.findAll());
    }

    public TurmaFormacaoDto buscarPeloId(Integer turmaFormacaoId) {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.findById(turmaFormacaoId)
                .orElseThrow(() -> new RuntimeException(String.format("Não existe uma turma com codigo %d", turmaFormacaoId))));
    }

    public TurmaFormacaoDto salvar(TurmaFormacaoDto turmaFormacaoDto) {
        TurmaFormacao turma = turmaFormacaoMapper.toEntity(turmaFormacaoDto);
        Integer statusId = turma.getStatus().getId();
        Status status = statusService.buscarPorId(statusId)
                .orElseThrow(() -> new RegraNegocioException(
                        String.format("Não existe um cadastro de status com código %d", statusId)
                ));
        turma.setStatus(status);
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turma));
    }

    public TurmaFormacaoDto atualizar(Integer turmaFormacaoId, TurmaFormacaoDto turmaFormacaoDto) {
        TurmaFormacao turmaFormacaoAtual = turmaFormacaoRepository.findById(turmaFormacaoId)
                .orElseThrow(() -> new RuntimeException(String.format("Não existe uma turma com codigo %d", turmaFormacaoId)));
        BeanUtils.copyProperties(turmaFormacaoDto, turmaFormacaoAtual, "id");
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turmaFormacaoAtual));
    }

    public void excluir(Integer turmaFormacaoId) {
        turmaFormacaoRepository.deleteById(turmaFormacaoId);
    }
}
