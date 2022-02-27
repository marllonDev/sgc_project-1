package com.basis.sgcproject.resource;

import com.basis.sgcproject.service.CompetenciaService;
import com.basis.sgcproject.service.dto.ListCompetenciaDTO;
import com.basis.sgcproject.service.dto.input.PostCompetenciaDTO;
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
    public ResponseEntity<List<ListCompetenciaDTO>> buscar(){
        return ResponseEntity.ok(service.buscar());
    }

    @PostMapping
    public ResponseEntity<PostCompetenciaDTO> salvar(@RequestBody PostCompetenciaDTO postCompetenciaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(postCompetenciaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCompetenciaDTO> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostCompetenciaDTO> atualizar(@RequestBody PostCompetenciaDTO postCompetenciaDTO){
        return ResponseEntity.ok(service.salvar(postCompetenciaDTO));
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<List<ListCompetenciaDTO>> findAllByCategoriaId(@PathVariable Integer id){
        return ResponseEntity.ok(service.findAllByCategoriaId(id));
    }
}