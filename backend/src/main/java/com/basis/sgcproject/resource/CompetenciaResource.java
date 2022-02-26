package com.basis.sgcproject.resource;

import com.basis.sgcproject.service.CompetenciaService;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
@AllArgsConstructor
public class CompetenciaResource {

    private final CompetenciaService service;


    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> buscar(){

        return ResponseEntity.ok(service.buscar());

    }

    @PostMapping
    public ResponseEntity<CompetenciaDTO> salvar(@RequestBody CompetenciaDTO competenciaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(competenciaDTO));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> buscarPorId(@PathVariable Integer id){

        return ResponseEntity.ok(service.buscarPorId(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){

        service.deletar(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> atualizar(@RequestBody CompetenciaDTO competenciaDTO){

        return ResponseEntity.ok(service.salvar(competenciaDTO));

    }
}