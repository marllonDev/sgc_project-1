package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusService {

    StatusRepository statusRepository;
    public Optional<Status> buscarPorId(Integer statusId) {
        return statusRepository.findById(statusId);
    }
}
