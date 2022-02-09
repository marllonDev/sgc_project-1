package com.basis.sgcproject.service;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;
    public List<Status> listarTodas(){

        return statusRepository.findAll();
    }
    public Status buscarId(Integer id){
        Optional<Status> obj = statusRepository.findById(id);
        return obj.get();
    }
}
