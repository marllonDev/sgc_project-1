package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.exception.RegraNegocioException;
import com.basis.sgcproject.repository.SenioridadeRepository;
import com.basis.sgcproject.repository.StatusRepository;
import com.basis.sgcproject.repository.TurmaFormacaoRepository;
import com.basis.sgcproject.service.dto.SenioridadeDTO;
import com.basis.sgcproject.service.dto.StatusDTO;
import com.basis.sgcproject.service.mapper.SenioridadeMapper;
import com.basis.sgcproject.service.mapper.StatusMapper;
import com.basis.sgcproject.service.mapper.TurmaFormacaoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusService {

    private final StatusMapper statusMapper;
    private final StatusRepository statusRepository;

    public List<StatusDTO> buscar() {
        return statusMapper.toDto(statusRepository.findAll());
    }

    public Status buscarPeloId(Integer statusId) {
        return statusRepository.findById(statusId)
                .orElseThrow(() -> new RegraNegocioException(
                        String.format("Não existe um cadastro de status com código %d", statusId)
                ));
    }
}
