package com.basis.sgcproject.resource;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
@AllArgsConstructor

public class StatusResource {
    StatusRepository statusRepository;
    @GetMapping
    public List<Status> listarTodas(){

        return statusRepository.findAll();
    }
    @GetMapping ("/{id}")
    public Optional<Status> buscarId(@PathVariable Integer id){

        return statusRepository.findById(id);
    }
    @PostMapping
    public Status salvar(@RequestBody Status status){
        return statusRepository.save(status);
    }
    @DeleteMapping(path = {"/{id}"})
    public Optional <Status> delete(@PathVariable("id") Integer id){
        return statusRepository.findById(id);}
    @PutMapping(value = "/{id}")
    public Optional <Status> atualizar(@PathVariable("id") Integer id, @RequestBody Status status){
        return statusRepository.findById(id);
    }
}
