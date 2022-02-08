package com.basis.sgcproject.resource;

import com.basis.sgcproject.domain.Senioridade;
import com.basis.sgcproject.repository.SenioridadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/senioridades")
@AllArgsConstructor

public class SenioridadeResource {
    SenioridadeRepository senioridadeRepository;
    @GetMapping
    public List <Senioridade> listarTodas(){

        return  senioridadeRepository.findAll();
    }
    @GetMapping (path = {"/{id}"})
    public Optional<Senioridade> buscarId(@PathVariable Integer id){

        return senioridadeRepository.findById(id);
    }
    @PostMapping
    public Senioridade salvar(@RequestBody Senioridade senioridade){

        return senioridadeRepository.save(senioridade);
    }
    @DeleteMapping(path = {"/{id}"})
    public Optional <Senioridade> delete(@PathVariable("id") Integer id){

        return senioridadeRepository.findById(id);
    }
    @PutMapping(value = "/{id}")
    public Optional <Senioridade> atualizar(@PathVariable("id") Integer id, @RequestBody Senioridade senioridade){
        return senioridadeRepository.findById(id);
    }
}
